package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeAntwoord;
import nl.han.ica.oose.ooad.models.vragen.MeerkeuzeVraag;

import java.util.List;

public class MeerkeuzeVraagView {
   private MeerkeuzeVraag meerkeuzeVraag;

    public MeerkeuzeVraagView(MeerkeuzeVraag meerkeuzeVraag) {
        this.meerkeuzeVraag = meerkeuzeVraag;
    }

    public void setMeerkeuzeVraag(MeerkeuzeVraag meerkeuzeVraag) {
        this.meerkeuzeVraag = meerkeuzeVraag;
    }

    public void displayVraag(){
        System.out.println(meerkeuzeVraag);
    }

    public void displayAntwoorden(){
        List<MeerkeuzeAntwoord> antwoorden = meerkeuzeVraag.getAntwoorden();

        for (MeerkeuzeAntwoord antwoord : antwoorden){
            System.out.println(antwoord);
        }
    }
}
