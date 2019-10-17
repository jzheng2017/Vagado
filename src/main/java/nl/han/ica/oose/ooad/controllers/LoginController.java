package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.User;

public class LoginController extends Controller {

    public LoginController() {
        setType(ControllerType.Login);
    }

    public boolean login(String username, String password) {
        if (authorized()) {
            User.setCurrentUser(new User(1, "jiankai", "zheng")); //not real login implementation but only faked data
            return true;
        } else {
            System.out.println("Je mag deze actie niet uitvoeren");
            return false;
        }
    }

    @Override
    public boolean authorized() {
        return !User.loggedIn();
    }
}
