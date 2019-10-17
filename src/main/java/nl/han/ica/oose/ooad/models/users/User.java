package nl.han.ica.oose.ooad.models.users;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class User {
    private static User currentUser;
    private int id;
    private int saldo;
    private String username;
    private String password;
    private List<Vragenlijst> vragenlijst;


    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, int saldo, String username, String password) {
        this.id = id;
        this.saldo = saldo;
        this.username = username;
        this.password = password;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setVragenlijst(List<Vragenlijst> vragenlijst) {
        this.vragenlijst = vragenlijst;
    }
}
