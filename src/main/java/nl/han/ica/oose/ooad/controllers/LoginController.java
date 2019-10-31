package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.Login;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.managers.UserManager;
import nl.han.ica.oose.ooad.views.LoginView;

public class LoginController extends Controller {
    private LoginView loginView;

    public LoginController() {
        setType(ControllerType.Login);
    }

    public boolean login(String username, String password) {
        UserManager userManager = UserManager.getInstance();
        if (authorized()) {
            loginView = new LoginView(new Login(username, password));
            User user = userManager.getByUsername(username);
            if (!user.getPassword().equals(password)) user = null;
            if (user != null) {
                User.setCurrentUser(user);
                return true;
            } else {
                LoginView.invalid();
                return false;
            }
        } else {
            System.out.println("Je mag deze actie niet uitvoeren");
            return false;
        }
    }

    @Override
    protected boolean authorized() {
        return !User.loggedIn();
    }

    public void entryMessage() {
        LoginView.notLoggedIn();
        LoginView.choice();
    }

    public void exitMessage() {
        LoginView.successful();
        loginView.welcome();
    }
}
