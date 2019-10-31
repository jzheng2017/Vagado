package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.QuizController;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class SelectionState extends State {
    private QuizController quizController;

    public SelectionState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void entry() {
        quizController = (QuizController) controllerManager.getController(ControllerType.Quiz);
    }

    @Override
    public void loop() {
        int selection = quizController.startSelection();
        if (selection == 1) {
            exit();
            stateMachine.setCurrentState(new QuizState(stateMachine));
        } else if (selection == -1){
            stateMachine.setCurrentState(new MainMenuState(stateMachine));
        }
    }

    @Override
    public void exit() {
        quizController.selectionExitMessage();
    }
}
