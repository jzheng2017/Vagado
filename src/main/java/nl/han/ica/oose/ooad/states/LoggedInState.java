package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.models.users.User;

public class LoggedInState extends State {
    public LoggedInState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void start() {
        System.out.println("Welkom " + User.getCurrentUser().getUsername() + ". Je bent nu ingelogd.");
    }

    @Override
    public void loop() {
        exit();
        stateMachine.setCurrentState(new IdleState(stateMachine));
    }

    @Override
    protected void exit() {
        //nothing
    }
}
