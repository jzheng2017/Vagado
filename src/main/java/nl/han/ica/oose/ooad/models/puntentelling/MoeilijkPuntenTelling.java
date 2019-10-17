package nl.han.ica.oose.ooad.models.puntentelling;

public class MoeilijkPuntenTelling implements PuntenTelling {
    @Override
    public int bereken(int correct, boolean alleVragenGoed) {
        int puntVoorVraagGoed = 5;
        int puntenVoorAlleVragenGoed = 75;
        int punten = correct * puntVoorVraagGoed;
        if (alleVragenGoed) punten += puntenVoorAlleVragenGoed;
        return punten;
    }
}
