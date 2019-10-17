package nl.han.ica.oose.ooad.models.vragen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VraagCollection {
    private List<Vraag> vragen;

    public VraagCollection(List<Vraag> vragen) {
        this.vragen = vragen;
    }

    public List<Vraag> getVragen(int aantal) {
        List<Vraag> vragen = new ArrayList<>();
        Random rnd = new Random();

        if (aantal > this.vragen.size()) {
            aantal = this.vragen.size();
            System.out.println("Het aantal dat is opgegeven is groter dan het aantal dat in de vragenlijst zit, het aantal is gelijk gezet aan het aantal van de vragenlijst.");
        }

        while (vragen.size() < aantal) {
            Vraag vraag = this.vragen.get(rnd.nextInt(this.vragen.size() - 1)); //random vraag uit vragenlijst
            if (!vragen.contains(vraag)) {
                vragen.add(vraag);
            }
        }

        return vragen;
    }

    public List<Vraag> getVragen(){
        return this.vragen;
    }
}
