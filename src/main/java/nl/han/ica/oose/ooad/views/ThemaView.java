package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.hierarchie.Onderwerp;
import nl.han.ica.oose.ooad.models.hierarchie.Thema;

import java.util.List;

public class ThemaView {
    private Thema thema;


    public ThemaView(Thema thema) {
        this.thema = thema;
    }

    public void display(){
        System.out.println(thema);
    }
}
