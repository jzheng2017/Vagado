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

    public boolean equals(String s) {
        return naam.equalsIgnoreCase(s);
    }

    public String toString(){
        return this.naam;
    }

    public List<Onderwerp> getOnderwerpen() {
        return onderwerpen;
    }

    public void setOnderwerpen(List<Onderwerp> onderwerpen) {
        this.onderwerpen = onderwerpen;
    }
}
