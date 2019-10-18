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
//        StateMachine stateMachine = new StateMachine();
//        while (true) {
//            stateMachine.execute();
//        }

        ControllerManager controllerManager = ControllerManager.getInstance();

        VragenlijstController vc = (VragenlijstController)controllerManager.getController(ControllerType.Vragenlijst);
        Vragenlijst v = vc.getVragenlijst();

        OpenVraag ov = (OpenVraag)v.getVragen().get(0);
        OpenVraagView ovv = new OpenVraagView(ov);
        ovv.displayVraag();
        ovv.displayAntwoorden();
        System.out.println(ov.isAntwoordCorrect("Gay"));

        MeerkeuzeVraag mv = (MeerkeuzeVraag)v.getVragen().get(1);
        MeerkeuzeVraagView mview = new MeerkeuzeVraagView(mv);
        mview.displayVraag();
        mview.displayAntwoorden();
        System.out.println(mv.isAntwoordCorrect("b"));
    }
}
