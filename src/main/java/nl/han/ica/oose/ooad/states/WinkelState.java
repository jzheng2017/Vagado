package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.WinkelController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.enums.SelectionState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WinkelState extends State {
    private WinkelController winkelController;
    private SelectionState proces;
    private Scanner scanner = new Scanner(System.in);

    public WinkelState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        winkelController = (WinkelController) controllerManager.getController(ControllerType.Winkel);
        winkelController.getWelcome();
        proces = SelectionState.THEMA;
    }

    @Override
    public void loop() {
        try {
            switch (proces) {
                case THEMA:
                    winkelController.displayThemaList();
                    winkelController.leaveMessage();
                    if (winkelController.pickThema(scanner.nextInt())) {
                        proces = SelectionState.ONDERWERP;
                    }
                    break;
                case ONDERWERP:
                    winkelController.displayOnderwerpList();
                    if (winkelController.pickOnderwerp(scanner.nextInt())) {
                        proces = SelectionState.VRAGENLIJST;
                    }
                    break;
                case VRAGENLIJST:
                    winkelController.displayVragenlijst();
                    if (winkelController.buyVragenlijst(scanner.nextInt())) {
                        proces = SelectionState.DONE;
                    }
                    break;
                case DONE:
                    String choice = scanner.nextLine();
                    winkelController.choice();
                    if (choice.equalsIgnoreCase("O")) {
                        proces = SelectionState.THEMA;
                    } else if (choice.equalsIgnoreCase("M")) {
                        exit();
                    }
                    break;
            }
        } catch (InputMismatchException e){
            exit();
        }
    }

    @Override
    protected void exit() {
        winkelController.exitMessage();
        stateMachine.setCurrentState(new MainMenuState(stateMachine));
    }
}
