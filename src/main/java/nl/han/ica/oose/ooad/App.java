package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.languages.Language;

public class App {
    private StateMachine stateMachine = new StateMachine();
    private static Language appLanguage;

    public App(){

    }

    public static Language getAppLanguage() {
        return appLanguage;
    }

    public static void setAppLanguage(Language appLanguage) {
        App.appLanguage = appLanguage;
    }

    public void start(){
        while (true) {
            stateMachine.execute();
        }
    }
}
