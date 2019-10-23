package nl.han.ica.oose.ooad.models.users;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static User currentUser;
    private int saldo = 100;
    private String username;
    private String password;
    private boolean isAdmin = false;
    private List<Vragenlijst> vragenlijsten;


    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        vragenlijsten = new ArrayList<>();
    }

    public User(int saldo, String username, String password, boolean isAdmin) {
        this.saldo = saldo;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        vragenlijsten = new ArrayList<>();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public static boolean loggedIn() {
        return currentUser != null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vragenlijst> getVragenlijsten() {
        return vragenlijsten;
    }

    public int getSaldo() {
        return saldo;
    }


    public boolean verminderSaldo(int aantal) {
        if (saldo >= aantal) {
            this.saldo -= aantal;
            return true;
        } else {
            return false;
        }
    }

    public void addVragenlijst(Vragenlijst vragenlijst){
        this.vragenlijsten.add(vragenlijst);
    }

    public void setVragenlijsten(List<Vragenlijst> vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }

    public static boolean isAdmin() {
        return currentUser.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
