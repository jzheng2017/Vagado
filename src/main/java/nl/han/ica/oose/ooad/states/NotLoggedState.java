package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.LoginController;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class NotLoggedState extends State {
    private LoginController loginController = (LoginController) controllerManager.getController(ControllerType.Login);

    public NotLoggedState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void start() {
        System.out.println("Je bent niet ingelogd. Log nu in.");
    }

    @Override
    public void loop() {
        if (loginController.login("jiankai", "zheng")) {
            exit();
            stateMachine.setCurrentState(new LoggedInState(stateMachine));
        } else {
            System.out.println("Invalide inloggegevens. Probeer het opnieuw!");
        }
    }

    @Override
    public void exit() {
        System.out.println("Succesvol ingelogd!");
    }
}
