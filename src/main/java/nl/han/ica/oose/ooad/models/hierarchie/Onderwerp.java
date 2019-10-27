package nl.han.ica.oose.ooad.models.hierarchie;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Onderwerp {
    private String naam;
    private List<Vragenlijst> vragenlijsten;

    public Onderwerp(String naam, List<Vragenlijst> vragenlijsten) {
        this.naam = naam;
        this.vragenlijsten = vragenlijsten;
    }

    public boolean equals(String s) {
        return naam.equalsIgnoreCase(s);
    }


    public String toString(){
        return this.naam;
    }

    public Vragenlijst getVragenlijst(int index){
        return vragenlijsten.get(index);
    }
    
    public List<Vragenlijst> getVragenlijsten() {
        return vragenlijsten;
    }

    public void setVragenlijsten(List<Vragenlijst> vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }
}
