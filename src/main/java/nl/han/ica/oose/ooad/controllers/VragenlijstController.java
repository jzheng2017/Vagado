package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.factories.VragenlijstFactory;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;

import java.util.ArrayList;

public class VragenlijstController extends Controller {

    @Override
    boolean authorized() {
        return User.loggedIn();
    }

    public VragenlijstCollection getVragenlijst(){
        VragenlijstCollection vc = new VragenlijstCollection(new ArrayList<>());
        VragenlijstFactory vf = new VragenlijstFactory();
        vc.add(vf.maakVragenlijst(VragenlijstType.OPEN));
        return vc;
    }
}
