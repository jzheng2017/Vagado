package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.controllers.*;
import nl.han.ica.oose.ooad.enums.ControllerType;

public class ControllerFactory {

    /**
     * Gets a controller based on the passed in Controller Type
     * @param type
     * @return Controller
     */
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
            case MainMenu:
                return new MainMenuController();
            case Beheer:
                return new BeheerController();
            default:
                return null;
        }
    }
}
