package nl.han.ica.oose.ooad.views;

public class MainMenuView {

    public void options(){
        System.out.println("1. Speel quiz");
        System.out.println("2. Winkel");
        System.out.println("3. Beheer");
    }

    public void invalidChoice(){
        System.out.println("Keuze moet tussen 1 en 3");
    }

    public void formatError(){
        System.out.println("Invalide keuze");
    }

    public void entry() {
        System.out.println("Welkom bij het hoofdmenu");
    }
}
