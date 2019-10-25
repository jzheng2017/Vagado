package nl.han.ica.oose.ooad.managers;

import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private List<Quiz> quizzes = new ArrayList<>();

    public Quiz getQuiz(Vragenlijst vragenlijst) {
        for (Quiz quiz : quizzes) {
            if (quiz.equals(vragenlijst)) {
                return quiz;
            }
        }
        return null;
    }

    public void addQuiz(Quiz quiz) {
        this.quizzes.add(quiz);
    }
}
