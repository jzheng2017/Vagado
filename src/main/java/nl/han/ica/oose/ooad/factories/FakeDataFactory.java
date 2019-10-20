package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.ArrayList;
import java.util.List;

public class FakeDataFactory {

    public static List<Thema> getThemaFilledWithSubjects() {
        List<Thema> list = new ArrayList<>();
        list.add(new Thema("Entertainment"));
        List<Onderwerp> onderwerpen = new ArrayList<>();

        List<Vragenlijst> vragenlijst = new ArrayList<>();
        vragenlijst.add(VragenlijstFactory.getInstance().maakVragenlijst(VragenlijstType.MIXED));
        onderwerpen.add(new Onderwerp(list.get(0), "Marvel", vragenlijst));
        list.get(0).setOnderwerpen(onderwerpen);
        list.add(new Thema("Sports"));
        List<Onderwerp> onderwerpen2 = new ArrayList<>();
        onderwerpen2.add(new Onderwerp(list.get(1), "Football", vragenlijst));
        list.get(1).setOnderwerpen(onderwerpen2);
        return list;
    }
}
