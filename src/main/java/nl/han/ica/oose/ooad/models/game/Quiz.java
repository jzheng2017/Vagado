package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.App;
import nl.han.ica.oose.ooad.models.puntentelling.PuntenTelling;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vraag;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Quiz {
    private static Quiz currentQuiz;
    private Vragenlijst vragenlijst;
    private List<Vraag> vragen;
    private int highscore;
    private int score;
    private int aantalCorrect = 0;
    private int huidigeVraag = -1;
    private boolean playing = false;

    public Quiz(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public static Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public static void setCurrentQuiz(Quiz currentQuiz) {
        Quiz.currentQuiz = currentQuiz;
    }

    public List<Vraag> getVragen() {
        return vragen;
    }

    public void setVragen(List<Vraag> vragen) {
        this.vragen = vragen;
    }

    public int getAantalCorrect() {
        return aantalCorrect;
    }

    public int getHighscore() {
        return highscore;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getScore() {
        berekenScore();
        return score;
    }

    public boolean next() {
        huidigeVraag++;
        if ( huidigeVraag < vragen.size()) {
            return true;
        } else {
            toggle();
            return false;
        }
    }

    private void berekenScore() {
        score = App.getInstance().getPuntenTelling().bereken(aantalCorrect, aantalCorrect == vragen.size());
        if (highscore < score) highscore = score;
    }

    public void start() {
        this.vragen = vragenlijst.getVragen(10);
        toggle();
    }

    private void toggle() {
        this.playing = !this.playing;
    }

    public void answer(String answer) {
        if (vragen.get(huidigeVraag).isAntwoordCorrect(answer)) {
            aantalCorrect++;
        }
    }

    public Vraag getHuidigeVraag() {
        return this.vragen.get(huidigeVraag);
    }
}
