package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.game.Winkel;
import nl.han.ica.oose.ooad.models.users.User;

public class WinkelController extends Controller {
    private Winkel winkel;

    public WinkelController(){
        setType(ControllerType.Winkel);
    }
    @Override
    public boolean authorized() {
        return User.loggedIn();
    }

}
