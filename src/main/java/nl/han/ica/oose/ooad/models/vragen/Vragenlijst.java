package nl.han.ica.oose.ooad.models.vragen;

import nl.han.ica.oose.ooad.models.hierarchie.Thema;
import nl.han.ica.oose.ooad.models.puntentelling.PuntenTelling;

import java.util.List;

public class Vragenlijst {
    private String thema;
    private String onderwerp;
    private PuntenTelling puntenTelling;
    private VraagCollection vragen;
    private String naam;
    private int prijs;

    public Vragenlijst(String thema, String onderwerp, VraagCollection vragen, String naam, int prijs) {
        this.thema = thema;
        this.onderwerp = onderwerp;
        this.vragen = vragen;
        this.naam = naam;
        this.prijs = prijs;
    }

    public Vragenlijst(String thema, String onderwerp, PuntenTelling puntenTelling, VraagCollection vragen, String naam, int prijs) {
        this.thema = thema;
        this.onderwerp = onderwerp;
        this.puntenTelling = puntenTelling;
        this.vragen = vragen;
        this.naam = naam;
        this.prijs = prijs;
    }

    public void setPuntenTelling(PuntenTelling puntenTelling) {
        this.puntenTelling = puntenTelling;
    }

    public PuntenTelling getPuntenTelling() {
        return puntenTelling;
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

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }
}
