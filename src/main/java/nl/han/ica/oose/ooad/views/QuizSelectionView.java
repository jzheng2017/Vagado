package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;

import java.util.List;

public class QuizSelectionView {
    private VragenlijstCollection vragenlijstCollection;

    public QuizSelectionView(VragenlijstCollection vragenlijstCollection) {
        this.vragenlijstCollection = vragenlijstCollection;
    }

    public void display() {
        List<Vragenlijst> lijst = vragenlijstCollection.getVragenlijsten();
        System.out.println("Kies uw vragenlijst.");
        for (int i = 1; i <= lijst.size(); i++){
            System.out.println(i + ". " + lijst.get(i - 1));
        }
    }

    public void setVragenlijstCollection(VragenlijstCollection vragenlijstCollection) {
        this.vragenlijstCollection = vragenlijstCollection;
    }
}
