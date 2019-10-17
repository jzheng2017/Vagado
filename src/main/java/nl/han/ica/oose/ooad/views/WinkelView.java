package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.game.Winkel;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class WinkelView {
    private Winkel winkel;

    public WinkelView(Winkel winkel) {
        this.winkel = winkel;
    }

    public void setWinkel(Winkel winkel) {
        this.winkel = winkel;
    }

    public void display() {
        List<Vragenlijst> vragenlijst = winkel.getVragenlijsten();

       for (int i = 1; i < vragenlijst.size() - 1; i++){
           System.out.println(i + ". " + vragenlijst.get(i - 1));
       }
    }

}
