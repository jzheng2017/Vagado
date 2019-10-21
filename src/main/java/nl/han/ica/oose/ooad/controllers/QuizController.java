package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.MeerkeuzeVraagView;
import nl.han.ica.oose.ooad.views.OpenVraagView;
import nl.han.ica.oose.ooad.views.QuizSelectionView;
import nl.han.ica.oose.ooad.views.QuizView;

import java.util.List;
import java.util.Scanner;

public class QuizController extends Controller {
    private Scanner scanner = new Scanner(System.in);
    private Vragenlijst vragenlijst;
    private List<Vragenlijst> vragenlijstList;
    private Quiz quiz;
    private QuizView quizView;
    private OpenVraagView openVraagView;
    private QuizSelectionView quizSelectionView;
    private MeerkeuzeVraagView meerkeuzeVraagView;

    public QuizController() {
        setType(ControllerType.Quiz);
    }

    @Override
    boolean authorized() {
        return User.loggedIn() && User.getCurrentUser().getVragenlijst().size() > 0;
    }

    public int startSelection() {
        vragenlijstList = User.getCurrentUser().getVragenlijst();
        quizSelectionView = new QuizSelectionView(vragenlijstList);
        if (authorized()) {
            quizSelectionView.display();
            int choice = scanner.nextInt();
            scanner.nextLine(); //skip the line because nextInt() does not consume the newline input created by hitting "Enter"
            if (choice < 0 || choice > vragenlijstList.size()) {
                quizSelectionView.invalid();
                return 0;
            } else {
                vragenlijst = vragenlijstList.get(choice - 1);
                return 1;
            }
        } else {
            quizSelectionView.unauthorized();
            return -1;
        }
    }

    public boolean startQuiz() {
        if (authorized()) {
            Quiz.setCurrentQuiz(new Quiz(vragenlijst, User.getCurrentUser()));
            quiz = Quiz.getCurrentQuiz();
            quizView = new QuizView(quiz);
            quiz.start();
        } else {
            quizSelectionView.unauthorized();
        }
        return true;
    }

    public void playQuiz() {
        if (quiz.next()){
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

    public void endMessage() {
        quizView.end();
    }
}
