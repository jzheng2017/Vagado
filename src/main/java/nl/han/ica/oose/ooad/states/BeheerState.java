package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.BeheerController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.enums.SelectionState;

import java.util.InputMismatchException;
import java.util.Scanner;

import static nl.han.ica.oose.ooad.enums.SelectionState.NONE;

public class BeheerState extends State {
    private BeheerController beheerController;
    private SelectionState proces;
    private Scanner scanner = new Scanner(System.in);

    public BeheerState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        beheerController = (BeheerController) controllerManager.getController(ControllerType.Beheer);
        if (!beheerController.initial()) {
            stateMachine.setCurrentState(new IdleState(stateMachine));
            proces = SelectionState.NONE;
        } else {
            proces = SelectionState.THEMA;
        }
    }

    @Override
    public void loop() {
        try {
            switch (proces) {
                case THEMA:
                    beheerController.displayThemaList();
                    beheerController.leaveMessage();
                    if (beheerController.pickThema(scanner.nextInt())) {
                        proces = SelectionState.ONDERWERP;
                    }
                    break;
                case ONDERWERP:
                    beheerController.displayOnderwerpList();
                    if (beheerController.pickOnderwerp(scanner.nextInt())) {
                        proces = SelectionState.VRAGENLIJST;
                    }
                    break;
                case VRAGENLIJST:
                    beheerController.displayVragenlijst();
                    if (beheerController.pickVragenlijst(scanner.nextInt())) {
                        proces = SelectionState.EDIT;
                        scanner.nextLine(); //skip new line
                    }
                    break;
                case EDIT:
                    beheerController.displayEditCurrentVragenlijst();
                    if (beheerController.updateVragenlijst(scanner.nextLine())) {
                        beheerController.displayCurrentVragenlijst();
                        proces = SelectionState.DONE;
                    }
                    break;
                case DONE:
                    beheerController.choice();
                    String choice = scanner.nextLine();
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
        beheerController.exitMessage();
        stateMachine.setCurrentState(new IdleState(stateMachine));
    }
}
