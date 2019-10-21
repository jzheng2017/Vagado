package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.factories.FakeDataFactory;
import nl.han.ica.oose.ooad.models.game.Beheer;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.BeheerView;

import java.util.List;

public class BeheerController extends Controller {
    private Beheer beheer;
    private BeheerView beheerView;


    public BeheerController() {
        setType(ControllerType.Beheer);
        beheer = new Beheer(FakeDataFactory.getThemaFilledWithSubjects());
        beheerView = new BeheerView(beheer);
    }

    @Override
    boolean authorized() {
        return User.isAdmin();
    }


    public boolean initial() {
        if (authorized()) {
            beheerView.welcome();
            return true;
        } else {
            beheerView.unauthorized();
            return false;
        }
    }

    public void displayThemaList() {
        beheerView.displayThema();
    }


    public boolean pickThema(int num) {
        if (num < 0 || num > beheer.getThemaList().size()) {
            beheerView.invalid();
            return false;
        } else {
            beheer.setCurrentThema(num);
            return true;
        }
    }

    public boolean pickOnderwerp(int num) {
        if (num < 0 || num > beheer.getOnderwerpList().size()) {
            beheerView.invalid();
            return false;
        } else {
            beheer.setCurrentOnderwerp(num);
            return true;
        }
    }

    public void displayOnderwerpList() {
        beheerView.displayOnderwerpList();
    }

    public void displayVragenlijst() {
        beheerView.displayVragenlijsten();
    }


    public boolean pickVragenlijst(int vragenlijst) {
        if (vragenlijst < 0 || vragenlijst > beheer.getVragenlijst().size()) {
            beheerView.invalid();
            return false;
        } else {
            beheer.setCurrentVragenlijst(vragenlijst);
            return true;
        }
    }

    public Vragenlijst getCurrentVragenlijst() {
        return beheer.getCurrentVragenlijst();
    }

    public boolean updateVragenlijst(String s) {
        beheer.changeNameCurrentVragenlijst(s);
        return true;
    }

    public void choice() {
        beheerView.choice();
    }

    public void displayEditCurrentVragenlijst() {
        beheerView.displayEditCurrentVragenlijst();
    }

    public void displayCurrentVragenlijst() {
        beheerView.displayCurrentVragenlijst();
    }

    public void exitMessage() {
        beheerView.exit();
    }

    public void leaveMessage(){
        beheerView.leave();
    }
}
