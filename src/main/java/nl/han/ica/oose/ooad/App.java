package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.languages.Language;
import nl.han.ica.oose.ooad.models.puntentelling.PuntenTelling;

public class App {
    private static App app;
    private StateMachine stateMachine = new StateMachine();
    private Language appLanguage;

    private App(){
    }

    public static App getInstance(){
        if (app == null){
            app = new App();
        }
        return app;
    }
    public Language getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(Language appLanguage) {
        this.appLanguage = appLanguage;
    }

    public void start(){
        while (true) {
            stateMachine.execute();
        }
    }
}
