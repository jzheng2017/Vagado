package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.WinkelController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.enums.OrderStatus;

import java.util.Scanner;

public class WinkelState extends State {
    private WinkelController winkelController;
    private OrderStatus proces;
    private Scanner scanner = new Scanner(System.in);

    public WinkelState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        winkelController = (WinkelController) controllerManager.getController(ControllerType.Winkel);
        winkelController.getWelcome();
        proces = OrderStatus.THEMA;
    }

    @Override
    public void loop() {
        switch (proces) {
            case THEMA:
                winkelController.displayThemaList();
                if (winkelController.pickThema(scanner.nextInt())) {
                    proces = OrderStatus.ONDERWERP;
                }
                break;
            case ONDERWERP:
                winkelController.displayOnderwerpList();
                if (winkelController.pickOnderwerp(scanner.nextInt())) {
                    proces = OrderStatus.VRAGENLIJST;
                }
                break;
            case VRAGENLIJST:
                winkelController.displayVragenlijst();
                if (winkelController.buyVragenlijst(scanner.nextInt())) {
                    proces = OrderStatus.DONE;
                }
                break;
            case DONE:
                String choice = scanner.nextLine();
                winkelController.choice();
                if (choice.equalsIgnoreCase("O")) {
                    proces = OrderStatus.THEMA;
                } else if (choice.equalsIgnoreCase("M")) {
                    exit();
                    stateMachine.setCurrentState(new IdleState(stateMachine));
                }
                break;
        }
    }

//    private boolean leave(){
//        winkelController.leaveMessage();
//        if (scanner.nextLine().equalsIgnoreCase("M")){
//            stateMachine.setCurrentState(new IdleState(stateMachine));
//            return true;
//        }
//        return false;
//    }

    @Override
    protected void exit() {
        winkelController.exitMessage();
    }
}
