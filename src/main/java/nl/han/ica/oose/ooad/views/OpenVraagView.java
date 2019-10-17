package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Antwoord;
import nl.han.ica.oose.ooad.models.vragen.OpenVraag;
import nl.han.ica.oose.ooad.models.vragen.OpenVraagAntwoord;

import java.util.List;

public class OpenVraagView {
   private OpenVraag openVraag;


    public OpenVraagView(OpenVraag openVraag) {
        this.openVraag = openVraag;
    }

    public void setOpenVraag(OpenVraag openVraag) {
        this.openVraag = openVraag;
    }

    public void displayVraag(){
        System.out.println(openVraag);
    }

    public void displayAntwoorden(){
       List<OpenVraagAntwoord> antwoorden = openVraag.getAntwoorden();

       for (OpenVraagAntwoord antwoord : antwoorden){
           System.out.println(antwoord);
       }
    }
}
