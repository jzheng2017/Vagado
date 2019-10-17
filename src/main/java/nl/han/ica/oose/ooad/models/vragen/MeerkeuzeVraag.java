package nl.han.ica.oose.ooad.models.vragen;

import java.util.List;

public class MeerkeuzeVraag extends Vraag {
    private List<MeerkeuzeAntwoord> antwoorden;

    public MeerkeuzeVraag(String vraag, List<MeerkeuzeAntwoord> antwoorden) {
        super(vraag);
        this.antwoorden = antwoorden;
    }

    @Override
    public boolean isAntwoordCorrect(String antwoord) {
        for (MeerkeuzeAntwoord a : antwoorden) {
            if (a.equals(antwoord) && a.isCorrect()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MeerkeuzeAntwoord> getAntwoorden() {
        return antwoorden;
    }

    public void setAntwoorden(List<MeerkeuzeAntwoord> antwoorden) {
        this.antwoorden = antwoorden;
    }
}
