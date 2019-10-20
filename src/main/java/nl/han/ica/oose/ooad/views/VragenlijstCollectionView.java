package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;

import java.util.List;

public class VragenlijstCollectionView {
    private List<Vragenlijst> vragenlijstList;

    public VragenlijstCollectionView(List<Vragenlijst> vragenlijstCollection){
        this.vragenlijstList = vragenlijstCollection;
    }

    public void setVragenlijstList(List<Vragenlijst> vragenlijstList) {
        this.vragenlijstList = vragenlijstList;
    }

    public void display() {
        for (int i = 0; i < vragenlijstList.size(); i++){
           System.out.println((i + 1) + ". " + vragenlijstList.get(i));
        }
    }
}
