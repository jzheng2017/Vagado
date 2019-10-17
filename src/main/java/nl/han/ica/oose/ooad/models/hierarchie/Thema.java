package nl.han.ica.oose.ooad.models.hierarchie;

public class Thema{
    private String naam;

    public Thema(String naam) {
        this.naam = naam;
    }

    public boolean equals(String s) {
        return naam.equalsIgnoreCase(s);
    }

}
