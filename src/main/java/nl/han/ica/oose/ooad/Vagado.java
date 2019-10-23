package nl.han.ica.oose.ooad;

import nl.han.ica.oose.ooad.models.puntentelling.MakkelijkPuntenTelling;

public class Vagado {
    public static void main(String[] args) {
        App app = App.getInstance();
        app.setPuntenTelling(new MakkelijkPuntenTelling());
        app.start();
    }
}
