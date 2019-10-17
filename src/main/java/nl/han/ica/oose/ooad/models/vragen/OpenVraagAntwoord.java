package nl.han.ica.oose.ooad.models.vragen;

public class OpenVraagAntwoord implements Antwoord {
    private String antwoord;

    public OpenVraagAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    @Override
    public boolean equals(String s) {
        return antwoord.equalsIgnoreCase(s);
    }

    public String toString(){
        return this.antwoord;
    }
}
