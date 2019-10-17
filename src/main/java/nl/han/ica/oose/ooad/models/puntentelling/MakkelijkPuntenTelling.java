package nl.han.ica.oose.ooad.models.puntentelling;

public class MakkelijkPuntenTelling implements PuntenTelling {
    @Override
    public int bereken(int correct, boolean alleVragenGoed) {
        int puntVoorVraagGoed = 1;
        int puntenVoorAlleVragenGoed = 10;
        int punten = correct * puntVoorVraagGoed;
        if (alleVragenGoed) punten += puntenVoorAlleVragenGoed;
        return punten;
    }
}
