package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.factories.VragenlijstFactory;
import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeVraag;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.MeerkeuzeVraagView;
import nl.han.ica.oose.ooad.views.VragenlijstView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vagado {
    public static void main(String[] args) {
//        StateMachine stateMachine = new StateMachine();
//        while (true) {
//            stateMachine.execute();
//        }

        VragenlijstFactory vf = new VragenlijstFactory();
        Vragenlijst v = vf.maakVragenlijst(VragenlijstType.MIXED);
        VragenlijstView view =new VragenlijstView(v);
        view.displayNaam();
        view.display();
        MeerkeuzeVraag mv = (MeerkeuzeVraag)v.getVragen().get(1);
        MeerkeuzeVraagView mview = new MeerkeuzeVraagView(mv);
        mview.displayVraag();
        mview.displayAntwoorden();
        System.out.println(mv.isAntwoordCorrect("b"));
    }
}
