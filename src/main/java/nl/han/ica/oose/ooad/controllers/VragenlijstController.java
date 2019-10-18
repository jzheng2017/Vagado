package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.factories.VragenlijstFactory;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;

import java.util.ArrayList;

public class VragenlijstController extends Controller {

    VragenlijstFactory vf = VragenlijstFactory.getInstance();

    public VragenlijstController(){
        setType(ControllerType.Vragenlijst);
    }
    @Override
    boolean authorized() {
        return User.loggedIn();
    }

    public Vragenlijst getVragenlijst(){
        return vf.maakVragenlijst(VragenlijstType.MIXED);
    }
}
