package nl.han.ica.oose.ooad.states;

import nl.han.ica.oose.ooad.StateMachine;
import nl.han.ica.oose.ooad.controllers.QuizController;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class QuizState extends State {
    private QuizController quizController;
    public QuizState(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    protected void entry() {
        quizController = (QuizController)controllerManager.getController(ControllerType.Quiz);
        quizController.startQuiz();
    }

    @Override
    public void loop() {
        quizController.playQuiz();
        if (!quizController.isPlaying()){
            exit();
            stateMachine.setCurrentState(new IdleState(stateMachine));
        }
    }

    @Override
    protected void exit() {
        quizController.endMessage();
    }
}
