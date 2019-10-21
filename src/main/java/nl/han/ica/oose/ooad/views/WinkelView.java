package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.game.Winkel;
import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
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

    public void welcome() {
        System.out.println("Welkom in de winkel, kies een vragenlijst door het nummer in te voeren.");
    }

    public void displayThema() {
        List<Thema> themaList = winkel.getThemaList();
        System.out.println("Kies een thema: ");
        for (int i = 0; i < themaList.size(); i++) {
            System.out.println((i + 1) + ". " + themaList.get(i));
        }
    }

    public void invalid() {
        System.out.println("Invalide keuze!");
    }

    public void displayOnderwerpList(int currentThema) {
        List<Onderwerp> onderwerpList = winkel.getOnderwerpList(currentThema);
        System.out.println("Kies een onderwerp: ");
        for (int i = 0; i < onderwerpList.size(); i++) {
            System.out.println((i + 1) + ". " + onderwerpList.get(i));
        }
    }

    public void displayVragenlijst(int currentThema, int currentOnderwerp) {
        List<Vragenlijst> vragenlijst = winkel.getVragenlijst(currentThema, currentOnderwerp);

        System.out.println("Kies een vragenlijst: ");

        for (int i = 0; i < vragenlijst.size(); i++) {
            System.out.println((i + 1) + ". " + vragenlijst.get(i));
        }
    }

    public void insufficient() {
        System.out.println("Niet genoeg saldo!");
    }

    public void successfull(int price, int balance) {
        System.out.println("De vragenlijst is succesvol toegevoegd aan uw vragenlijst collectie. " +
                "Het aankoopbedrag is afgeschreven van uw saldo. Uw aankoopbedrag was: "
                + price + ". Uw saldo is verlaagd van " + (balance + price) + " naar " + balance);
    }

    public void choice(){
        System.out.println("Kies M om terug te keren naar het start menu of O om een nieuwe aankoop te doen.");
    }
    public void leave(){
        System.out.println("Kies M om de winkel te verlaten.");
    }
    public void exit() {
        System.out.println("Je verlaat nu de winkel. Tot de volgende keer.");
    }
}
