package nl.han.ica.oose.ooad.models.users;

import nl.han.ica.oose.ooad.managers.QuizManager;
import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.vragen.UserVragenlijst;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static User currentUser;
    private int saldo = 100;
    private String username;
    private String password;
    private boolean isAdmin = false;
    private List<UserVragenlijst> vragenlijsten = new ArrayList<>();
    private QuizManager quizManager = new QuizManager();

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    public User(int saldo, String username, String password, boolean isAdmin) {
        this.saldo = saldo;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
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
        return vragenlijsten.stream().map(UserVragenlijst::getVragenlijst).collect(Collectors.toList());
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

    public void verhoogSaldo(int aantal){
        saldo += aantal;
    }

    public boolean expired(Vragenlijst vragenlijst) {
        for (UserVragenlijst uv : vragenlijsten) {
            if (uv.getVragenlijst().equals(vragenlijst) && uv.expired()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasVragenlijst(Vragenlijst vragenlijst) {
        for (UserVragenlijst uv : vragenlijsten) {
            if (uv.getVragenlijst().equals(vragenlijst)) {
                return true;
            }
        }
        return false;
    }

    public void addVragenlijst(Vragenlijst vragenlijst) {
        this.vragenlijsten.add(new UserVragenlijst(vragenlijst));
    }

    public void setVragenlijsten(List<UserVragenlijst> vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }

    public static boolean isAdmin() {
        return currentUser.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void addQuiz(Quiz quiz){
        quizManager.addQuiz(quiz);
    }

    public Quiz getQuiz(Vragenlijst vragenlijst){
        return quizManager.getQuiz(vragenlijst);
    }
}
