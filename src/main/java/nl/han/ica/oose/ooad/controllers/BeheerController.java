package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.User;

public class BeheerController extends Controller {

    public BeheerController() {
        setType(ControllerType.Beheer);
    }

    @Override
    boolean authorized() {
        return User.isAdmin();
    }


    public void initial() {
        if (authorized()) {

        } else {

        }
    }
}
