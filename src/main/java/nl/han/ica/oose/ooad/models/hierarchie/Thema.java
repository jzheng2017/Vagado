package nl.han.ica.oose.ooad.models.hierarchie;

import java.util.List;

public class Thema{
    private String naam;
    private List<Onderwerp> onderwerpen;

    public Thema(String naam) {
        this.naam = naam;
    }

    public Thema(String naam, List<Onderwerp> onderwerpen) {
        this.naam = naam;
        this.onderwerpen = onderwerpen;
    }

    /**
     * Checks whether passed in string equals to the name of the current object
     * @param thema
     * @return boolean
     */
    public boolean equals(String thema) {
        return naam.equalsIgnoreCase(thema);
    }

    /**
     * Returns a string of the theme name
     * @return String
     */
    public String toString(){
        return this.naam;
    }

    /**
     * Gets all subjects associated with this class
     * @return list
     */
    public List<Onderwerp> getOnderwerpen() {
        return onderwerpen;
    }

    /**
     * Sets the subjects to this object
     * @param onderwerpen
     */
    public void setOnderwerpen(List<Onderwerp> onderwerpen) {
        this.onderwerpen = onderwerpen;
    }
}
