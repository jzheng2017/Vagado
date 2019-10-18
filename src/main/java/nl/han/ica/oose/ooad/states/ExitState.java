package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;

public class ExitState extends State {
    public ExitState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void start() {
        System.out.println("Bedankt voor het spelen. De applicatie wordt nu afgesloten.");
        exit();
    }

    @Override
    public void loop() {

    }

    @Override
    protected void exit() {
        System.exit(0);
    }
}
