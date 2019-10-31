package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.vragen.Antwoord;
import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeVraag;

import java.util.List;

public class QuizView extends View{

    private Quiz quiz;

    public QuizView(Quiz quiz) {
        this.quiz = quiz;
    }

    public void unauthorized() {
        System.out.println("Je mag deze actie niet uitvoeren.  Je bent niet ingelogd of je hebt geen vragenlijst(en). Je wordt terug gekeerd naar het start scherm.");
    }
    public void end() {
        System.out.println("Het spel is geeindigd. Je hebt " + quiz.getAantalCorrect() + " van de " + quiz.getVragen().size() + " correct.");
        System.out.println("Tijd over gedaan: " + quiz.getTotalTime() + "s");
        System.out.println("Je oude highscore is: " + quiz.getHighscore());
        System.out.println("Je eindscore is: " + quiz.getScore());
        System.out.println("Je nieuwe highscore is: " + quiz.getHighscore());
    }

    public void display() {
        System.out.println(quiz.getHuidigeVraag());
        if (quiz.getHuidigeVraag() instanceof MeerkeuzeVraag) {
            List<Antwoord> antwoorden = quiz.getHuidigeVraag().getAntwoorden();
            for (Antwoord antwoord : antwoorden){
                System.out.println(antwoord);
            }
        }
    }
}
