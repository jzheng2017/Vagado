package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;

import java.util.List;

public class VragenlijstCollectionView {
    private VragenlijstCollection vragenlijstCollection;

    public VragenlijstCollectionView(VragenlijstCollection vragenlijstCollection){
        this.vragenlijstCollection = vragenlijstCollection;
    }

    public void setVragenlijstCollection(VragenlijstCollection vragenlijstCollection) {
        this.vragenlijstCollection = vragenlijstCollection;
    }

    public void display() {
        List<Vragenlijst> lijst = vragenlijstCollection.getVragenlijsten();
        for (int i = 1; i <= lijst.size(); i++){
           System.out.println(i + ". " + lijst.get(i - 1));
        }
    }
}
