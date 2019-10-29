package nl.han.ica.oose.ooad.models.vragen;

import java.util.List;

public abstract class Vraag<T> {
    private String vraag;

    protected Vraag(String vraag) {
        this.vraag = vraag;
    }


    public abstract boolean isAntwoordCorrect(String antwoord);

    public abstract List<T> getAntwoorden();

    public abstract void addAntwoord(T antwoord);

    public abstract void removeAntwoord(T antwoord);

    public String toString(){
        return vraag;
    }

}
