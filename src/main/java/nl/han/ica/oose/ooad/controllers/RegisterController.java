package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.factories.FakeDataFactory;
import nl.han.ica.oose.ooad.models.users.Register;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.managers.UserManager;
import nl.han.ica.oose.ooad.views.RegisterView;

public class RegisterController extends Controller {
    private RegisterView registerView;

    public RegisterController() {
        setType(ControllerType.Register);
    }

    /**
     * Register the guest based on the username and password given
     * @param username
     * @param password
     */
    public void register(String username, String password) {
        Register register = new Register(username, password);
        registerView = new RegisterView(register);
        UserManager userManager = UserManager.getInstance();
        if (!register.isUsernameTaken()) {
            User user = new User(register.getUsername(), register.getPassword(), false);
            user.verhoogSaldo(100);
            user.addVragenlijst(FakeDataFactory.getMixedVragenlijst());
            user.addVragenlijst(FakeDataFactory.getMixedVragenlijst2());
            userManager.add(user);
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
