package nl.han.ica.oose.ooad.models.hierarchie;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class Onderwerp {
    private Thema thema;
    private String naam;
    private List<Vragenlijst> vragenlijst;

    public Onderwerp(Thema thema, String naam, List<Vragenlijst> vragenlijst) {
        this.thema = thema;
        this.naam = naam;
        this.vragenlijst = vragenlijst;
    }

    public boolean equals(String s) {
        return naam.equalsIgnoreCase(s);
    }

    public Thema getThema() {
        return thema;
    }

    public String toString(){
        return this.naam;
    }

    public Vragenlijst getVragenlijst(int index){
        return vragenlijst.get(index);
    }
    public List<Vragenlijst> getVragenlijst() {
        return vragenlijst;
    }

    public void setVragenlijst(List<Vragenlijst> vragenlijst) {
        this.vragenlijst = vragenlijst;
    }
}
