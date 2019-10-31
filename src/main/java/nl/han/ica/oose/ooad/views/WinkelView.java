package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.game.Winkel;
import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class WinkelView extends View{
    private Winkel winkel;

    public WinkelView(Winkel winkel) {
        this.winkel = winkel;
    }

    public void setWinkel(Winkel winkel) {
        this.winkel = winkel;
    }

    /**
     * Welcome message
     */
    public void welcome() {
        System.out.println(language.translate("Welkom in de winkel, kies een vragenlijst door het nummer in te voeren."));
    }

    /**
     * Display all themes
     */
    public void displayThema() {
        List<Thema> themaList = winkel.getThemaList();
        System.out.println("Kies een thema: ");
        for (int i = 0; i < themaList.size(); i++) {
            System.out.println((i + 1) + ". " + themaList.get(i));
        }
    }

    /**
     * Invalid choice message
     */
    public void invalid() {
        System.out.println("Invalide keuze!");
    }

    /**
     * Display list of subject
     */
    public void displayOnderwerpList() {
        List<Onderwerp> onderwerpList = winkel.getOnderwerpList();
        System.out.println("Kies een onderwerp: ");
        for (int i = 0; i < onderwerpList.size(); i++) {
            System.out.println((i + 1) + ". " + onderwerpList.get(i));
        }
    }

    /**
     * Display list of vragenlijst
     */
    public void displayVragenlijst() {
        List<Vragenlijst> vragenlijst = winkel.getVragenlijst();

        System.out.println("Kies een vragenlijst: ");

        for (int i = 0; i < vragenlijst.size(); i++) {
            System.out.println((i + 1) + ". " + vragenlijst.get(i));
        }
    }

    /**
     * Insufficient balance message
     */
    public void insufficient() {
        System.out.println("Niet genoeg saldo!");
    }

    /**
     * Message that displays the item has been succesfully bought.
     * @param price
     * @param balance
     */
    public void successful(int price, int balance) {
        System.out.println("De vragenlijst is succesvol toegevoegd aan uw vragenlijst collectie. " +
                "Het aankoopbedrag is afgeschreven van uw saldo. Uw aankoopbedrag was: "
                + price + ". Uw saldo is verlaagd van " + (balance + price) + " naar " + balance);
    }


    public void choice(){
        System.out.println("Kies M om terug te keren naar het start menu of O om een nieuwe aankoop te doen.");
    }
    public void leave(){
        System.out.println("Je kan de winkel op elk moment verlaten, kies een willekeurig non numeriek karakter om de winkel te verlaten.");
    }

    /**
     * Exit message
     */
    public void exit() {
        System.out.println("Je verlaat nu de winkel. Tot de volgende keer.");
    }

    /**
     * Display a message to let the user know it has already bought this item
     */
    public void duplicate() {
        System.out.println("Je bent al in bezit van deze vragenlijst!");
    }
}
