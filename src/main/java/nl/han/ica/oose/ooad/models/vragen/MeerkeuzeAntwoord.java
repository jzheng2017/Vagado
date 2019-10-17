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
    public boolean equals(String s) {
        return keuze.equalsIgnoreCase(s) || antwoord.equalsIgnoreCase(s);
    }

    public boolean isCorrect(){
        return isCorrect;
    }

    public String toString(){
        return keuze + ". " + antwoord;
    }
}
