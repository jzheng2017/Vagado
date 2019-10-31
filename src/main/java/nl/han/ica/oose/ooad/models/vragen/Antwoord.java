package nl.han.ica.oose.ooad.models.vragen;

public interface Antwoord {

    /**
     * Compares the passed in answer with the answer of the current instance, returns true if correct else returns false
     * @param answer
     * @return correct or not
     */
    boolean equals(String answer);


}
