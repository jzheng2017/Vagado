package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.states.IdleState;
import nl.han.ica.oose.ooad.states.NotLoggedState;
import nl.han.ica.oose.ooad.states.State;

public class StateMachine {
    private State currentState;

    public StateMachine() {
        setup();
    }

    public void execute() {
        currentState.loop();
    }


    private void setup() {
        currentState = User.loggedIn() ? new IdleState(this) : new NotLoggedState(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
