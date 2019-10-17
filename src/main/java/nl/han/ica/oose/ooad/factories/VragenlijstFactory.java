package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.enums.VragenlijstType;
import nl.han.ica.oose.ooad.models.vragen.*;

import java.util.ArrayList;
import java.util.List;

public class VragenlijstFactory {


    public Vragenlijst maakVragenlijst(VragenlijstType type) {
        switch (type) {
            case OPEN:
                return maakOpenVragenlijst();
            case MEERKEUZE:
                return maakMeerkeuzeVragenlijst();
            case MIXED:
                return maakMixedVragenlijst();
            default:
                return null;
        }
    }

    private Vragenlijst maakMixedVragenlijst() {
        List<Vraag> vragen = new ArrayList<>();
        List<OpenVraagAntwoord> openAntwoorden = new ArrayList<>();

        openAntwoorden.add(new OpenVraagAntwoord("Iron man"));
        openAntwoorden.add(new OpenVraagAntwoord("Thor"));
        openAntwoorden.add(new OpenVraagAntwoord("Captain America"));
        openAntwoorden.add(new OpenVraagAntwoord("Spiderman"));

        vragen.add(new OpenVraag("Noem een mcu superheld", openAntwoorden));

        List<MeerkeuzeAntwoord> meerkeuzeAntwoorden = new ArrayList<>();

        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("A", "2007", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("B", "2008", true));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("C", "2009", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("D", "2005", false));

        vragen.add(new MeerkeuzeVraag("Wanneer was de eerste MCU film uitgekomen?", meerkeuzeAntwoorden));

        return new Vragenlijst("Films", "Marvel", new VraagCollection(vragen), "marvel vragenlijst", 5);
    }

    private Vragenlijst maakMeerkeuzeVragenlijst() {
        return null;
    }

    private Vragenlijst maakOpenVragenlijst() {
        return null;
    }
}
