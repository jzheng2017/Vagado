package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.Controller;
import nl.han.ica.oose.ooad.controllers.ControllerManager;

public abstract class State {
    protected ControllerManager controllerManager;
    protected Controller currentController;
    protected StateMachine stateMachine;

    public State(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.controllerManager = ControllerManager.getInstance();
        start();
    }

    protected abstract void start();

    public abstract void loop();

    protected abstract void exit();
}
