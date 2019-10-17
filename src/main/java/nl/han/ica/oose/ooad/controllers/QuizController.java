package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.models.users.User;

public class QuizController extends Controller {
    @Override
    boolean authorized() {
        return User.loggedIn();
    }


}
