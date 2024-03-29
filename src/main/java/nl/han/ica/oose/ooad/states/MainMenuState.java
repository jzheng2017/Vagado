package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.MainMenuController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import java.util.Scanner;

public class MainMenuState extends State {
    private Scanner scanner = new Scanner(System.in);
    private MainMenuController mainMenuController;

    public MainMenuState(StateMachine stateMachine) {
        super(stateMachine);

    }

    @Override
    protected void entry() {
        mainMenuController = (MainMenuController) controllerManager.getController(ControllerType.MainMenu);
        mainMenuController.entryMessage();
        mainMenuController.displayOptions();
    }

    @Override
    public void loop() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 0 && choice <= 3) {
                if (choice == 1) {
                    stateMachine.setCurrentState(new SelectionState(stateMachine));
                } else if (choice == 2) {
                    stateMachine.setCurrentState(new WinkelState(stateMachine));
                } else {
                    stateMachine.setCurrentState(new BeheerState(stateMachine));
                }
            } else {
                mainMenuController.displayInvalidChoiceMessage();
                mainMenuController.displayOptions();
            }
        } catch (NumberFormatException e) {
            mainMenuController.displayFormatError();
        }
    }

    @Override
    protected void exit() {
    }
}
