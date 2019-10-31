package nl.han.ica.oose.ooad.models.vragen;

import java.util.List;

public abstract class Vraag<T> {
    private String vraag;

    protected Vraag(String vraag) {
        this.vraag = vraag;
    }

    /**
     * Checks whether passed in answer can be found in list of existing answers
     * @param antwoord
     * @return boolean
     */
    public abstract boolean isAntwoordCorrect(String antwoord);

    /**
     * Gets list of all answers
     * @return list of answers
     */
    public abstract List<T> getAntwoorden();

    /**
     * Adds passed in answer to the list
     * @param antwoord
     */
    public abstract void addAntwoord(T antwoord);

    /**
     * Removes passed in answer from the list
     * @param antwoord
     */
    public abstract void removeAntwoord(T antwoord);

    /**
     * Returns the question string
     * @return String
     */
    public String toString(){
        return vraag;
    }

}
