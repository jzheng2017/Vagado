package nl.han.ica.oose.ooad.models.vragen;

public class OpenVraagAntwoord implements Antwoord {
    private String antwoord;

    public OpenVraagAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    @Override
    public boolean equals(String answer) {
        return antwoord.equalsIgnoreCase(answer);
    }

    /**
     * Displays the answer in a nice format
     * @return answer in correct format
     */
    public String toString(){
        return this.antwoord;
    }
}
