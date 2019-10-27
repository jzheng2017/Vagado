package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.vragen.Vraag;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.time.LocalDate;
import java.util.List;

public class Quiz {
    private static Quiz currentQuiz;
    private Vragenlijst vragenlijst;
    private List<Vraag> vragen;
    private int highscore;
    private int score;
    private int aantalCorrect = 0;
    private int huidigeVraag = -1;
    private long startTime;
    private long finishTime;
    private boolean playing = false;

    public Quiz(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public boolean equals(Vragenlijst vragenlijst) {
        return this.vragenlijst.equals(vragenlijst);
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
        if (huidigeVraag < vragen.size()) {
            return true;
        } else {
            toggle();
            return false;
        }
    }

    private void berekenScore() {
        score = vragenlijst.bereken(aantalCorrect, getTotalTime(),aantalCorrect == vragen.size());
        if (highscore < score) highscore = score;
    }

    public void start() {
        this.vragen = vragenlijst.getVragen(10);
        cleanup();
        toggle();
    }

    private void toggle() {
        this.playing = !this.playing;
        if (this.playing) {
            startTime = System.currentTimeMillis();
        } else {
            finishTime = System.currentTimeMillis();
        }
    }

    private void cleanup(){
        score = 0;
        huidigeVraag = -1;
        aantalCorrect = 0;
        startTime = 0;
        finishTime = 0;
    }

    public void answer(String answer) {
        if (vragen.get(huidigeVraag).isAntwoordCorrect(answer)) {
            aantalCorrect++;
        }
    }

    public Vraag getHuidigeVraag() {
        return this.vragen.get(huidigeVraag);
    }

    public long getStartTime() {
        return startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public int getTotalTime(){
        return (int)((finishTime - startTime) / 1000);
    }
}
