package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeVraag;
import nl.han.ica.oose.ooad.models.vragen.Vraag;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class VragenlijstView {
    private Vragenlijst vragenlijst;

    public VragenlijstView(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public void setVragenlijst(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public void displayNaam() {
        System.out.println(vragenlijst);
    }

    public void display() {
        List<Vraag> lijst = vragenlijst.getVragen();

        for (int i = 1; i <= lijst.size(); i++) {
            System.out.println(i + ". " + lijst.get(i - 1));
        }
    }
}
