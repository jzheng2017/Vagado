package nl.han.ica.oose.ooad.factories;

import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.managers.UserManager;
import nl.han.ica.oose.ooad.models.vragen.*;

import java.util.ArrayList;
import java.util.List;

public class FakeDataFactory {
    private static List<Thema> themaList;

    public static void getFakeUsers(){
        UserManager userManager = UserManager.getInstance();
        userManager.add(new User("jiankai", "zheng", true));
    }

    public static List<Thema> getThemaFilledWithSubjects() {
        if (themaList == null) {
            List<Thema> list = new ArrayList<>();
            list.add(new Thema("Entertainment"));
            List<Onderwerp> onderwerpen = new ArrayList<>();

            List<Vragenlijst> vragenlijst = new ArrayList<>();
            vragenlijst.add(getMixedVragenlijst());
            vragenlijst.add(getMixedVragenlijst2());
            onderwerpen.add(new Onderwerp(list.get(0), "Marvel", vragenlijst));
            list.get(0).setOnderwerpen(onderwerpen);
            list.add(new Thema("Sports"));
            List<Onderwerp> onderwerpen2 = new ArrayList<>();

            List<Vragenlijst> vragenlijst2 = new ArrayList<>();
            vragenlijst2.add(getMixedVragenlijst3());
            onderwerpen2.add(new Onderwerp(list.get(1), "Football", vragenlijst2));
            list.get(1).setOnderwerpen(onderwerpen2);
            themaList = list;
        }
        return themaList;
    }

    public static Vragenlijst getMixedVragenlijst() {
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

        return new Vragenlijst(new VraagCollection(vragen), "marvel vragenlijst", 5);
    }

    public static Vragenlijst getMixedVragenlijst2() {
        List<Vraag> vragen = new ArrayList<>();
        List<OpenVraagAntwoord> openAntwoorden = new ArrayList<>();

        openAntwoorden.add(new OpenVraagAntwoord("Bruce Banner"));
        openAntwoorden.add(new OpenVraagAntwoord("BruceBanner"));
        openAntwoorden.add(new OpenVraagAntwoord("the Incredible Hulk"));
        openAntwoorden.add(new OpenVraagAntwoord("Incredible Hulk"));

        vragen.add(new OpenVraag("Wat is de volledige naam van de hulk?", openAntwoorden));

        List<MeerkeuzeAntwoord> meerkeuzeAntwoorden = new ArrayList<>();

        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("A", "Aarde", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("B", "Asgard", true));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("C", "Midgard", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("D", "Alfheim", false));

        vragen.add(new MeerkeuzeVraag("Waar komt Thor vandaan?", meerkeuzeAntwoorden));

        return new Vragenlijst(new VraagCollection(vragen), "marvel vragenlijst 2", 8);
    }

    public static Vragenlijst getMixedVragenlijst3() {
        List<Vraag> vragen = new ArrayList<>();
        List<OpenVraagAntwoord> openAntwoorden = new ArrayList<>();

        openAntwoorden.add(new OpenVraagAntwoord("Spanje"));
        openAntwoorden.add(new OpenVraagAntwoord("Spanjaarden"));
        openAntwoorden.add(new OpenVraagAntwoord("de Spanjaarden"));

        vragen.add(new OpenVraag("Wie won het WK van 2010?", openAntwoorden));

        List<MeerkeuzeAntwoord> meerkeuzeAntwoorden = new ArrayList<>();

        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("A", "31 jaar", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("B", "32 jaar", true));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("C", "35 jaar", false));
        meerkeuzeAntwoorden.add(new MeerkeuzeAntwoord("D", "26 jaar", false));

        vragen.add(new MeerkeuzeVraag("Hoe oud is Lionel Messi?", meerkeuzeAntwoorden));

        return new Vragenlijst(new VraagCollection(vragen), "Voetbal vragenlijst", 5);
    }
}
