package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.QuizController;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class QuizState extends State {
    private QuizController quizController = (QuizController)controllerManager.getController(ControllerType.Quiz);
    public QuizState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void start() {
        quizController.startQuiz();
    }

    @Override
    public void loop() {

    }

    @Override
    protected void exit() {

    }
}
