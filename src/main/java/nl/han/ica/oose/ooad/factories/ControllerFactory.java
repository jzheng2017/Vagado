package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.controllers.Controller;
import nl.han.ica.oose.ooad.controllers.LoginController;
import nl.han.ica.oose.ooad.controllers.RegisterController;
import nl.han.ica.oose.ooad.controllers.WinkelController;
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
            default:
                return null;
        }
    }
}
