package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.LoginController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.views.LoginView;

public class NotLoggedState extends State {
    private LoginController loginController = (LoginController) controllerManager.getController(ControllerType.Login);

    public NotLoggedState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void entry() {
        LoginView.notLoggedIn();
    }

    @Override
    public void loop() {
        if (loginController.login("jiankai", "zheng")) {
            exit();
            stateMachine.setCurrentState(new IdleState(stateMachine));
        } else {
            LoginView.invalid();
        }
    }

    @Override
    public void exit() {
        LoginView.successfull();
        LoginView.welcome();
    }
}
