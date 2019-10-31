package nl.han.ica.oose.ooad.models.vragen;

import java.util.List;

public class OpenVraag extends Vraag<OpenVraagAntwoord> {
    private List<OpenVraagAntwoord> antwoorden;

    public OpenVraag(String vraag, List<OpenVraagAntwoord> antwoorden) {
        super(vraag);
        this.antwoorden = antwoorden;
    }


    @Override
    public boolean isAntwoordCorrect(String antwoord) {
        for (OpenVraagAntwoord a : antwoorden) {
            if (a.equals(antwoord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<OpenVraagAntwoord> getAntwoorden() {
        return antwoorden;
    }

    @Override
    public void addAntwoord(OpenVraagAntwoord antwoord) {
        antwoorden.add(antwoord);
    }

    @Override
    public void removeAntwoord(OpenVraagAntwoord antwoord) {
        antwoorden.remove(antwoord);
    }

    public void setAntwoorden(List<OpenVraagAntwoord> antwoorden) {
        this.antwoorden = antwoorden;
    }


}
