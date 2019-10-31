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
    protected boolean authorized() {
        return User.loggedIn();
    }

    /**
     * Display all options the user can perform
     */
    public void displayOptions(){
        mainMenuView.options();
    }

    /**
     * Displays when the user has given an invalid choice
     */
    public void displayInvalidChoiceMessage(){
        mainMenuView.invalidChoice();
    }

    /**
     * Displays when the user gives a non numeric input
     */
    public void displayFormatError(){
        mainMenuView.formatError();
    }

    /**
     * Displays this message when the users enters the main menu
     */
    public void entryMessage(){
        mainMenuView.entry();
    }
}
