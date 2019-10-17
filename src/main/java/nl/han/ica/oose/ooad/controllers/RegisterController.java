package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.models.users.User;

public class RegisterController extends Controller {

    public void register(String username, String password){

    }

    @Override
    public boolean authorized() {
        return !User.loggedIn();
    }
}
