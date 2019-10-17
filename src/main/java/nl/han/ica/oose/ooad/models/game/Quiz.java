package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vraag;

import java.util.List;

public class Quiz {
    private List<Vraag> vragen;
    private User speler;
    private int highscore;
    private int aantalCorrect = 0;

    public Quiz(List<Vraag> vragen, User speler) {
        this.vragen = vragen;
        this.speler = speler;
    }

    public User getSpeler() {
        return speler;
    }

    public void setSpeler(User speler) {
        this.speler = speler;
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

    public void verhoogAantalCorrect() {
        this.aantalCorrect++;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}
