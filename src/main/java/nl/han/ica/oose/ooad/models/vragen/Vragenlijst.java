package nl.han.ica.oose.ooad.models.vragen;

import nl.han.ica.oose.ooad.models.puntentelling.PuntenTelling;

import java.util.List;

public class Vragenlijst {
    private VraagCollection vragen;
    private String naam;
    private int prijs;

    public Vragenlijst(VraagCollection vragen, String naam, int prijs) {
        this.vragen = vragen;
        this.naam = naam;
        this.prijs = prijs;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public VraagCollection getVragenCollection() {
        return vragen;
    }

    public List<Vraag> getVragen(int aantal){
        return vragen.getVragen(aantal);
    }

    public List<Vraag> getVragen() {
        return vragen.getVragen();
    }

    public void setVragen(VraagCollection vragen) {
        this.vragen = vragen;
    }

    public String toString() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
