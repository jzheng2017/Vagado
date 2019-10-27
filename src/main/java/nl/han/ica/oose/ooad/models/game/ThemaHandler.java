package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public abstract class ThemaHandler {
    private List<Thema> themaList;
    private int currentThema;
    private int currentOnderwerp;

    public ThemaHandler(List<Thema> themaList) {
        this.themaList = themaList;
    }

    public List<Thema> getThemaList() {
        return themaList;
    }

    public List<Onderwerp> getOnderwerpList() {
        return themaList.get(currentThema - 1).getOnderwerpen();
    }

    public void setThemaList(List<Thema> themaList) {
        this.themaList = themaList;
    }

    public List<Vragenlijst> getVragenlijst() {
        return themaList.get(currentThema - 1).getOnderwerpen().get(currentOnderwerp - 1).getVragenlijsten();
    }


    public int getCurrentThema() {
        return currentThema;
    }

    public void setCurrentThema(int currentThema) {
        this.currentThema = currentThema;
    }

    public int getCurrentOnderwerp() {
        return currentOnderwerp;
    }

    public void setCurrentOnderwerp(int currentOnderwerp) {
        this.currentOnderwerp = currentOnderwerp;
    }
}
