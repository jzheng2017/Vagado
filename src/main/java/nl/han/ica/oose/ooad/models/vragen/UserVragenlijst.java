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

    /**
     * Gets the question list associated with this class
     * @return list
     */
    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }

    /**
     * Gets date of purchase
     * @return date
     */
    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * Checks whether the current instance has expired or not
     * @return boolean
     */
    public boolean expired(){
        return !Period.between(dateOfPurchase.plusYears(1), LocalDate.now()).isNegative();
    }
}
