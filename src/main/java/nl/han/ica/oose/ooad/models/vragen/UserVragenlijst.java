package nl.han.ica.oose.ooad.models.vragen;

import java.time.LocalDate;
import java.time.Period;

public class UserVragenlijst {
    private Vragenlijst vragenlijst;
    private LocalDate dateOfPurchase;

    public UserVragenlijst(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
        this.dateOfPurchase = LocalDate.now();
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public boolean expired(){
        return !Period.between(dateOfPurchase.plusYears(1), LocalDate.now()).isNegative();
    }
}
