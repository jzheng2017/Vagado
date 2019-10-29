package nl.han.ica.oose.ooad.models.puntentelling;

import nl.han.ica.oose.ooad.models.users.User;

public class MakkelijkPuntenTelling implements PuntenTelling {
    @Override
    public int bereken(int correct, int tijd, boolean alleVragenGoed) {
        int puntVoorVraagGoed = 1;
        int puntenVoorAlleVragenGoed = 10;
        int punten = correct * puntVoorVraagGoed;
        if (alleVragenGoed) {
            punten += puntenVoorAlleVragenGoed;
            User.getCurrentUser().verhoogSaldo(2);
        }
        if (tijd < 300) punten += 10;
        return punten;
    }
}
