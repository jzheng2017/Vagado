package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.users.Login;

public class LoginView {
    private Login login;

    public LoginView(Login login) {
        this.login = login;
    }

    public void welcome() {
        System.out.println("Welkom " +  login.getUsername() + ". Je bent nu ingelogd.");
    }

    public static void successfull() {
        System.out.println("Succesvol ingelogd!");
    }

    public static void invalid() {
        System.out.println("Invalide inloggegevens. Probeer het opnieuw!");
    }

    public static void notLoggedIn() {
        System.out.println("Je bent niet ingelogd. Log nu in.");
    }

    public static void choice(){
        System.out.println("Kies R voor registreren of L voor inloggen.");
    }
}
