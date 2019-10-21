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
    private List<Vragenlijst> vragenlijst;


    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        vragenlijst = new ArrayList<>();
    }

    public User(int saldo, String username, String password, boolean isAdmin) {
        this.saldo = saldo;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        vragenlijst = new ArrayList<>();
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

    public List<Vragenlijst> getVragenlijst() {
        return vragenlijst;
    }

    public int getSaldo() {
        return saldo;
    }

    public void verhoogSaldo(int aantal) {
        this.saldo += aantal;
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
        this.vragenlijst.add(vragenlijst);
    }

    public void setVragenlijst(List<Vragenlijst> vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public static boolean isAdmin() {
        return currentUser.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
