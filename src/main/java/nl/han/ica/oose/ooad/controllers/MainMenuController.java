package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.views.MainMenuView;

public class MainMenuController extends Controller {
    private MainMenuView mainMenuView = new MainMenuView();

    public MainMenuController(){
        setType(ControllerType.MainMenu);
    }

    @Override
    boolean authorized() {
        return User.loggedIn();
    }

    public void displayOptions(){
        mainMenuView.options();
    }

    public void displayInvalidChoiceMessage(){
        mainMenuView.invalidChoice();
    }

    public void displayFormatError(){
        mainMenuView.formatError();
    }

    public void entryMessage(){
        mainMenuView.entry();
    }
}
