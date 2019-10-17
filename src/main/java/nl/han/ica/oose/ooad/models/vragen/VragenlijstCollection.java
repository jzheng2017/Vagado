package nl.han.ica.oose.ooad.models.vragen;

import java.util.List;

public class VragenlijstCollection {
    private List<Vragenlijst> vragenlijsten;


    public VragenlijstCollection(List<Vragenlijst> vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }

    public void add(Vragenlijst vragenlijst) {
        this.vragenlijsten.add(vragenlijst);
    }

    public void remove(Vragenlijst vragenlijst) {
        this.vragenlijsten.remove(vragenlijst);
    }

    public void remove(int index) {
        this.vragenlijsten.remove(index);
    }

    public Vragenlijst getVragenlijst(int index) {
        return vragenlijsten.get(index - 1);
    }

    public List<Vragenlijst> getVragenlijsten() {
        return vragenlijsten;
    }
}
