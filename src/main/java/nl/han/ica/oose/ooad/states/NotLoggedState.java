package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.LoginController;
import nl.han.ica.oose.ooad.controllers.RegisterController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.factories.FakeDataFactory;

import java.util.Scanner;

public class NotLoggedState extends State {
    private LoginController loginController;
    private RegisterController registerController = (RegisterController) controllerManager.getController(ControllerType.Register);
    private Scanner scanner = new Scanner(System.in);

    public NotLoggedState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        loginController = (LoginController) controllerManager.getController(ControllerType.Login);
        FakeDataFactory.getFakeUsers();
        loginController.entryMessage();
    }

    @Override
    public void loop() {
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("L")) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (loginController.login(username, password)) {
                exit();
                stateMachine.setCurrentState(new MainMenuState(stateMachine));
                return;
            }
        } else if (choice.equalsIgnoreCase("R")) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            registerController.register(username, password);
        }
        loginController.entryMessage();
    }

    @Override
    protected void exit() {
        loginController.exitMessage();
    }
}
