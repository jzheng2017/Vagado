package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.controllers.*;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class ControllerFactory {

    public static Controller getController(ControllerType type) {
        switch (type) {
            case Login:
                return new LoginController();
            case Register:
                return new RegisterController();
            case Winkel:
                return new WinkelController();
            case Quiz:
                return new QuizController();
            case Vragenlijst:
                return new VragenlijstController();
            default:
                return null;
        }
    }
}
