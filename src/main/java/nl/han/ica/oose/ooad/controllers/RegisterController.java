package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.Register;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.users.UserManager;
import nl.han.ica.oose.ooad.views.RegisterView;

public class RegisterController extends Controller {
    private RegisterView registerView;

    public RegisterController() {
        setType(ControllerType.Register);
    }

    public void register(String username, String password) {
        Register register = new Register(username, password);
        registerView = new RegisterView(register);
        UserManager userManager = UserManager.getInstance();
        if (!register.isUsernameTaken()) {
            userManager.add(new User(register.getUsername(), register.getPassword(), false));
            registerView.successful();
        } else {
            registerView.taken();
        }
    }

    @Override
    protected boolean authorized() {
        return !User.loggedIn();
    }
}
