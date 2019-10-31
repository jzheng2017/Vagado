package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.QuizSelectionView;
import nl.han.ica.oose.ooad.views.QuizView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuizController extends Controller {
    private Scanner scanner = new Scanner(System.in);
    private Vragenlijst vragenlijst;
    private List<Vragenlijst> vragenlijsten;
    private Quiz quiz;
    private QuizView quizView;
    private QuizSelectionView quizSelectionView;

    public QuizController() {
        setType(ControllerType.Quiz);
    }

    @Override
    public boolean authorized() {
        return User.loggedIn() && User.getCurrentUser().getVragenlijsten().size() > 0;
    }

    public int startSelection() {
        if (authorized()) {
            try {
                vragenlijsten = User.getCurrentUser().getVragenlijsten();
                quizSelectionView = new QuizSelectionView(vragenlijsten);
                quizSelectionView.leave();
                quizSelectionView.display();
                int choice = scanner.nextInt();
                scanner.nextLine(); //skip the line because nextInt() does not consume the newline input created by hitting "Enter"
                if (choice < 0 || choice > vragenlijsten.size()) {
                    quizSelectionView.invalid();
                    return 0;
                } else {
                    vragenlijst = vragenlijsten.get(choice - 1);
                    if (User.getCurrentUser().expired(vragenlijst)) {
                        quizSelectionView.expired();
                        return 0;
                    }
                    return 1;
                }
            } catch (InputMismatchException e) {
                quizSelectionView.premature();
                return -1;
            }
        } else {
            QuizSelectionView.unauthorized();
            return -1;
        }
    }

    public void startQuiz() {
        if (authorized()) {
            quiz = User.getCurrentUser().getQuiz(vragenlijst);
            if (quiz == null) {
                quiz = new Quiz(vragenlijst);
                Quiz.setCurrentQuiz(quiz);
                User.getCurrentUser().addQuiz(quiz);
            }
            quizView = new QuizView(quiz);
            quiz.start();
        } else {
            quizView.unauthorized();
        }
    }

    public void playQuiz() {
        if (quiz.next()) {
            quizView.display();
            quiz.answer(scanner.nextLine());
        }
    }

    public boolean isPlaying() {
        return quiz.isPlaying();
    }

    public void selectionExitMessage() {
        quizSelectionView.exit();
    }

    public void leave() {
        quizSelectionView.leave();
    }

    public void endMessage() {
        quizView.end();
    }

    public void premature() {
        quizSelectionView.premature();
    }
}
