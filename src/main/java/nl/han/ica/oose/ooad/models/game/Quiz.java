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

    /**
     * Checks whether the passed in vragenlijst equals to the quiz vragenlijst
     * @param vragenlijst
     * @return boolean
     */
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

    /**
     * Gets the number of correctly answered questions
     * @return number of correct
     */
    public int getAantalCorrect() {
        return aantalCorrect;
    }

    /**
     * Gets the highscore of the current quiz instance
     * @return highscore
     */
    public int getHighscore() {
        return highscore;
    }

    /**
     * Checks whether the quiz is still being played
     * @return
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * Get score of current quiz
     * @return score
     */
    public int getScore() {
        berekenScore();
        return score;
    }

    /**
     * Checks whether there is a next question or not, if there isn't the quiz will proceed to end
     * @return if there is a next question, boolean
     */
    public boolean next() {
        huidigeVraag++;
        if (huidigeVraag < vragen.size()) {
            return true;
        } else {
            toggle();
            return false;
        }
    }

    /**
     * Calculate the score of current quiz
     */
    private void berekenScore() {
        score = vragenlijst.bereken(aantalCorrect, getTotalTime(),aantalCorrect == vragen.size());
        if (highscore < score) highscore = score;
    }

    /**
     * Starts the quiz
     */
    public void start() {
        this.vragen = vragenlijst.getVragen(10);
        cleanup();
        toggle();
    }

    /**
     * Sets the quiz state (playing or not playing)
     */
    private void toggle() {
        this.playing = !this.playing;
        if (this.playing) {
            startTime = System.currentTimeMillis();
        } else {
            finishTime = System.currentTimeMillis();
        }
    }

    /**
     * Resets all instance variables needed to calculate statistics
     */
    private void cleanup(){
        score = 0;
        huidigeVraag = -1;
        aantalCorrect = 0;
        startTime = 0;
        finishTime = 0;
    }

    /**
     * Checks whether passed in answer is correct
     * @param answer
     */
    public void answer(String answer) {
        if (vragen.get(huidigeVraag).isAntwoordCorrect(answer)) {
            aantalCorrect++;
        }
    }

    /**
     * Get current question
     * @return current question
     */
    public Vraag getHuidigeVraag() {
        return this.vragen.get(huidigeVraag);
    }

    /**
     * Get starting time of the quiz
     * @return starting time of quiz
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Get finish time of the quiz
     * @return finish time of quiz
     */
    public long getFinishTime() {
        return finishTime;
    }

    /**
     * Calculate total time of the quiz
     * @return total time of quiz
     */
    public int getTotalTime(){
        return (int)((finishTime - startTime) / 1000);
    }
}
