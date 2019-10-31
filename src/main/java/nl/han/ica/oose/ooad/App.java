package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.languages.Language;
import nl.han.ica.oose.ooad.models.puntentelling.PuntenTelling;

public class App {
    private static App app;
    private StateMachine stateMachine = new StateMachine();

    private App(){
    }

    /**
     * @author Jiankai Zheng
     * Get current instance
     * @return instance of App
     */
    public static App getInstance(){
        if (app == null){
            app = new App();
        }
        return app;
    }

    /**
     * Starts the statemachine
     */
    public void start(){
        while (true) {
            stateMachine.execute();
        }
    }
}
