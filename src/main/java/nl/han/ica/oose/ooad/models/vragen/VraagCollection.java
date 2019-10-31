package nl.han.ica.oose.ooad.models.vragen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VraagCollection {
    private List<Vraag> vragen;

    public VraagCollection(List<Vraag> vragen) {
        this.vragen = vragen;
    }

    /**
     * Gets a list of questions, the length of the list is based on the passed in parameter.
     * If the list is shorter than the given parameter then the parameter value will be changed accordingly.
     * @param aantal
     * @return list of questions
     */
    public List<Vraag> getVragen(int aantal) {
        List<Vraag> vragen = new ArrayList<>();
        Random rnd = new Random();

        if (aantal > this.vragen.size()) {
            System.out.println("Het aantal dat is opgegeven ("+ aantal +") is groter dan het aantal dat in de vragenlijst ("+ this.vragen.size() +") zit, het aantal is gelijk gezet aan het aantal van de vragenlijst.");
            aantal = this.vragen.size();
        }

        while (vragen.size() < aantal) {
            Vraag vraag = this.vragen.get(rnd.nextInt(this.vragen.size())); //random vraag uit vragenlijst
            if (!vragen.contains(vraag)) {
                vragen.add(vraag);
            }
        }

        return vragen;
    }

    /**
     * Gets all questions
     * @return list of questions
     */
    public List<Vraag> getVragen(){
        return this.vragen;
    }
}
