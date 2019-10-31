package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class QuizSelectionView extends View{
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

    public static void unauthorized() {
        System.out.println("Je mag deze actie niet uitvoeren.  Je bent niet ingelogd of je hebt geen vragenlijst(en). Je wordt terug gekeerd naar het start scherm.");
    }

    public void exit() {
        System.out.println("Er is een selectie gemaakt. De quiz gaat nu beginnen.");
    }

    public void invalid() {
        System.out.println("Invalide keuze. Kies tussen: 1 en " + vragenlijstList.size());
    }

    public void expired() {
        System.out.println("De vragenlijst die je hebt gekozen is verlopen. Om het te kunnen spelen moet je het vernieuwen. Doe dat door het opnieuw te kopen in de winkel.");
    }

    public void leave(){
        System.out.println("Je kan de winkel op elk moment verlaten, kies een willekeurig non numeriek karakter om de winkel te verlaten.");
    }

    public void premature() {
        System.out.println("Je verlaat nu de quiz selectie. Je word nu terug gekeerd naar het hoofdmenu.");
    }
}
