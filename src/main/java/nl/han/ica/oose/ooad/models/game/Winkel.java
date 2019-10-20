package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Winkel {
    private List<Thema> themaList;

    public Winkel(List<Thema> themaList) {
        this.themaList = themaList;
    }

    public List<Thema> getThemaList() {
        return themaList;
    }

    public List<Onderwerp> getOnderwerpList(int thema) {
        return themaList.get(thema - 1).getOnderwerpen();
    }

    public void setThemaList(List<Thema> themaList) {
        this.themaList = themaList;
    }

    public List<Vragenlijst> getVragenlijst(int currentThema, int currentOnderwerp) {
        return themaList.get(currentThema - 1).getOnderwerpen().get(currentOnderwerp - 1).getVragenlijst();
    }

}
