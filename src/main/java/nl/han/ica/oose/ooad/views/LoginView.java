package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.users.User;

public class LoginView {

    public static void welcome() {
        System.out.println("Welkom " + User.getCurrentUser().getUsername() + ". Je bent nu ingelogd.");
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
}
