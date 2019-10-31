package nl.han.ica.oose.ooad.models.puntentelling;

public interface PuntenTelling {

    /**
     * Calculate the score based on the formula
     * @param correct
     * @param tijd
     * @param alleVragenGoed
     * @return score
     */
    int bereken(int correct, int tijd, boolean alleVragenGoed);
}
