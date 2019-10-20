package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;

public class OnderwerpView {
    private Onderwerp onderwerp;


    public OnderwerpView(Onderwerp onderwerp) {
        this.onderwerp = onderwerp;
    }

    public void display(){
        System.out.println(onderwerp);
    }
}
