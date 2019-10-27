package nl.han.ica.oose.ooad.models.puntentelling;

public class MakkelijkPuntenTelling implements PuntenTelling {
    @Override
    public int bereken(int correct, int tijd, boolean alleVragenGoed) {
        int puntVoorVraagGoed = 1;
        int puntenVoorAlleVragenGoed = 10;
        int punten = correct * puntVoorVraagGoed;
        if (alleVragenGoed) punten += puntenVoorAlleVragenGoed;
        if (tijd < 300) punten += 10;
        return punten;
    }
}
