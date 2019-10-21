package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.BeheerController;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class BeheerState extends State {
    private BeheerController beheerController;

    public BeheerState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        beheerController = (BeheerController) controllerManager.getController(ControllerType.Beheer);
        beheerController.initial();
    }

    @Override
    public void loop() {

    }

    @Override
    protected void exit() {

    }
}
