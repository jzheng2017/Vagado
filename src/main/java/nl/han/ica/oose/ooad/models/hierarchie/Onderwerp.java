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

    /**
     * Checks whether the passed in parameter equals to the subject name
     * @param onderwerp
     * @return boolean
     */
    public boolean equals(String onderwerp) {
        return naam.equalsIgnoreCase(onderwerp);
    }

    /**
     * Returns a string of the subject name
     * @return String
     */
    public String toString(){
        return this.naam;
    }

    /**
     * Gets a vragenlijst based on the given parameter
     * @param index
     * @return vragenlijst
     */
    public Vragenlijst getVragenlijst(int index){
        return vragenlijsten.get(index);
    }

    /**
     * Gets a list of vragenlijst
     * @return list
     */
    public List<Vragenlijst> getVragenlijsten() {
        return vragenlijsten;
    }

    /**
     * Sets the list of vragenlijst
     * @param vragenlijsten
     */
    public void setVragenlijsten(List<Vragenlijst> vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }
}
