package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.QuizController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.User;

public class SelectionState extends State {
    private QuizController quizController = (QuizController) controllerManager.getController(ControllerType.Quiz);

    public SelectionState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void start() {
        quizController.setVragenlijstCollection(User.getCurrentUser().getVragenlijst());
    }

    @Override
    public void loop() {
        if (quizController.startSelection() == 0) {
            exit();
            stateMachine.setCurrentState(new QuizState(stateMachine));
        } else if (quizController.startSelection() == 2) {
            stateMachine.setCurrentState(new ExitState(stateMachine));
        }
    }

    @Override
    protected void exit() {
        System.out.println("Er is een selectie gemaakt. De quiz gaat nu beginnen.");
    }
}
