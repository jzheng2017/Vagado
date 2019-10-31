package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Beheer extends ThemaHandler {
    private Vragenlijst currentVragenlijst;

    public Beheer(List<Thema> themaList) {
        super(themaList);
    }

    /**
     * Change name of the current vragenlijst
     * @param s
     */
    public void changeNameCurrentVragenlijst(String s){
        currentVragenlijst.setNaam(s);
    }

    /**
     * Gets current vragenlijst
     * @return vragenlijst
     */
    public Vragenlijst getCurrentVragenlijst() {
        return currentVragenlijst;
    }

    /**
     * Sets the current vragenlijst based on the passed in index
     * @param vragenlijst
     */
    public void setCurrentVragenlijst(int vragenlijst) {
        this.currentVragenlijst = getVragenlijst().get(vragenlijst - 1);
    }
}
