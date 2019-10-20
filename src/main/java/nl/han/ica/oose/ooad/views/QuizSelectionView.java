package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class QuizSelectionView {
    private List<Vragenlijst> vragenlijstList;

    public QuizSelectionView(List<Vragenlijst> vragenlijstCollection) {
        this.vragenlijstList = vragenlijstCollection;
    }

    public void display() {
        System.out.println("Kies uw vragenlijst.");
        for (int i = 0; i < vragenlijstList.size(); i++) {
            System.out.println((i + 1) + ". " + vragenlijstList.get(i));
        }
    }

    public void setVragenlijstList(List<Vragenlijst> vragenlijstList) {
        this.vragenlijstList = vragenlijstList;
    }

    public void unauthorized() {
        System.out.println("Je mag deze actie niet uitvoeren.  Je bent niet ingelogd of je hebt geen vragenlijst(en). Je wordt terug gekeerd naar het start scherm.");
    }

    public void exit() {
        System.out.println("Er is een selectie gemaakt. De quiz gaat nu beginnen.");
    }

    public void invalid() {
        System.out.println("Invalide keuze. Kies tussen: 1 en " + vragenlijstList.size());
    }
}
