package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.ControllerManager;

public abstract class State {
    protected ControllerManager controllerManager;
    protected StateMachine stateMachine;

    public State(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.controllerManager = ControllerManager.getInstance();
        entry();
    }

    protected abstract void entry();

    public abstract void loop();

    protected abstract void exit();
}
