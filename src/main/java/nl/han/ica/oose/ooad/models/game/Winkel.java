package nl.han.ica.oose.ooad.models.game;

import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;

import java.util.List;

public class Winkel {
    private VragenlijstCollection vragenlijsten;

    public Winkel(VragenlijstCollection vragenlijsten) {
        this.vragenlijsten = vragenlijsten;
    }

    public VragenlijstCollection getVragenlijstenCollection() {
        return vragenlijsten;
    }

    public List<Vragenlijst> getVragenlijsten() {
        return vragenlijsten.getVragenlijsten();
    }

    public Vragenlijst get(int index){
        return vragenlijsten.getVragenlijst(index);
    }

    public void koop(int index){
        Vragenlijst vragenlijst = get(index);

        if (User.getCurrentUser().verminderSaldo(vragenlijst.getPrijs())){

        } else {
            System.out.println("Niet genoeg saldo!");
        }
    }
}
