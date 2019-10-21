package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Beheer extends ThemaHandler {
    private Vragenlijst currentVragenlijst;

    public Beheer(List<Thema> themaList) {
        super(themaList);
    }

    public void changeNameCurrentVragenlijst(String s){
        currentVragenlijst.setNaam(s);
    }

    public Vragenlijst getCurrentVragenlijst() {
        return currentVragenlijst;
    }

    public void setCurrentVragenlijst(int vragenlijst) {
        this.currentVragenlijst = getVragenlijst().get(vragenlijst - 1);
    }
}
