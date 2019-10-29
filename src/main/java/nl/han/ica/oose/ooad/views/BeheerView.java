package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.game.Beheer;
import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class BeheerView extends View{
    private Beheer beheer;

    public BeheerView(Beheer beheer) {
        this.beheer = beheer;
    }

    public void welcome() {
        System.out.println("Welkom " + User.getCurrentUser().getUsername() + ". Je bent nu in de beheeromgeving.");
    }

    public void unauthorized() {
        System.out.println("Je hebt geen toegang tot deze deel van het systeem. Je wordt teruggekeerd naar het hoofdmenu.");
    }

    public void invalid() {
        System.out.println("Invalide keuze");
    }

    public void displayThema() {
        List<Thema> themaList = beheer.getThemaList();
        System.out.println("Kies een thema: ");
        for (int i = 0; i < themaList.size(); i++) {
            System.out.println((i + 1) + ". " + themaList.get(i));
        }
    }

    public void displayOnderwerpList() {
        List<Onderwerp> onderwerpList = beheer.getOnderwerpList();
        System.out.println("Kies een onderwerp: ");
        for (int i = 0; i < onderwerpList.size(); i++) {
            System.out.println((i + 1) + ". " + onderwerpList.get(i));
        }
    }

    public void displayVragenlijsten() {
        List<Vragenlijst> vragenlijst = beheer.getVragenlijst();

        System.out.println("Kies een vragenlijst: ");

        for (int i = 0; i < vragenlijst.size(); i++) {
            System.out.println((i + 1) + ". " + vragenlijst.get(i));
        }
    }

    public void choice(){
        System.out.println("Kies M om terug te keren naar het start menu of O om een andere vragenlijst te bewerken");
    }

    public void displayEditCurrentVragenlijst() {
        System.out.println("Je hebt gekozen voor deze vragenlijst: ");
        System.out.println("====================");
        System.out.println("Naam: " + beheer.getCurrentVragenlijst());
        System.out.println("====================");
        System.out.println("Voer een nieuw naam in:");
    }

    public void displayCurrentVragenlijst(){
        System.out.println("De naam van de vragenlijst is gewijzigd.");
        System.out.println("Nieuwe naam: " + beheer.getCurrentVragenlijst());
    }

    public void exit() {
        System.out.println("Je verlaat nu de beheer. Je wordt terug gestuurd naar het hoofdmenu.");
    }

    public void leave(){
        System.out.println("Je kan de beheer op elk moment verlaten, kies een willekeurig non numeriek karakter om de beheer te verlaten.");
    }
}
