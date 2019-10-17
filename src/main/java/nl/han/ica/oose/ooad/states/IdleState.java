package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;

import java.util.Scanner;

public class IdleState extends State {
    Scanner scanner = new Scanner(System.in);

    public IdleState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void start() {
        System.out.println("1. Speel quiz");
        System.out.println("2. Winkel");
        System.out.println("3. Beheer");
    }

    @Override
    public void loop() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 0 && choice <= 3) {
                if (choice == 1) {
                    stateMachine.setCurrentState(new SelectionState(stateMachine));
                } else if (choice == 2){
                    stateMachine.setCurrentState(new WinkelState(stateMachine));
                }
            } else {
                System.out.println("Keuze moet tussen 1 en 3");
                start();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalide keuze");
        }
    }

    @Override
    protected void exit() {
    }
}
