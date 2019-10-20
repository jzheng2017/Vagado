package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.controllers.ControllerManager;
import nl.han.ica.oose.ooad.controllers.VragenlijstController;
import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.factories.VragenlijstFactory;
import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeVraag;
import nl.han.ica.oose.ooad.models.vragen.OpenVraag;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.MeerkeuzeVraagView;
import nl.han.ica.oose.ooad.views.OpenVraagView;
import nl.han.ica.oose.ooad.views.VragenlijstView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vagado {
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        while (true) {
            stateMachine.execute();
        }
    }
}
