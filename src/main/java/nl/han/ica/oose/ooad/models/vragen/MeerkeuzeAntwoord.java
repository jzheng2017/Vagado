package nl.han.ica.oose.ooad.models.vragen;

public class MeerkeuzeAntwoord implements Antwoord {
    private String keuze;
    private String antwoord;
    private boolean isCorrect;

    public MeerkeuzeAntwoord(String keuze, String antwoord, boolean isCorrect) {
        this.keuze = keuze;
        this.antwoord = antwoord;
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(String answer) {
        return keuze.equalsIgnoreCase(answer) || antwoord.equalsIgnoreCase(answer);
    }

    /**
     * Returns the whether the answer is correct
     * @return boolean
     */
    public boolean isCorrect(){
        return isCorrect;
    }

    /**
     * Displays the answer in a nice format
     * @return answer in correct format
     */
    public String toString(){
        return keuze + ". " + antwoord;
    }
}
