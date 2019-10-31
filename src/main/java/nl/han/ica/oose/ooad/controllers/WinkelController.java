package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.factories.FakeDataFactory;
import nl.han.ica.oose.ooad.models.game.Winkel;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.views.WinkelView;

public class WinkelController extends Controller {
    private Winkel winkel;
    private WinkelView winkelView;

    public WinkelController() {
        setType(ControllerType.Winkel);
        winkel = new Winkel(FakeDataFactory.getThemaFilledWithSubjects());
        winkelView = new WinkelView(winkel);
    }

    @Override
    public boolean authorized() {
        return User.loggedIn();
    }

    /**
     * Display welcome message
     */
    public void welcomeMessage() {
        winkelView.welcome();
    }

    /**
     * Display all themes
     */
    public void displayThemaList() {
        winkelView.displayThema();
    }

    /**
     * Sets the current theme based on the given parameter
     * @param num
     * @return boolean
     */
    public boolean pickThema(int num) {
        if (num < 0 || num > winkel.getThemaList().size()) {
            winkelView.invalid();
            return false;
        } else {
            winkel.setCurrentThema(num);
            return true;
        }
    }

    /**
     * Sets the current subject based on the given parameter
     * @param num
     * @return booelean
     */
    public boolean pickOnderwerp(int num) {
        if (num < 0 || num > winkel.getOnderwerpList().size()) {
            winkelView.invalid();
            return false;
        } else {
            winkel.setCurrentOnderwerp(num);
            return true;
        }
    }

    /**
     * Display all subject based on current theme
     */
    public void displayOnderwerpList() {
        winkelView.displayOnderwerpList();
    }

    /**
     * Display list of vragenlijst based on current theme and subject
     */
    public void displayVragenlijst() {
        winkelView.displayVragenlijst();
    }

    /**
     * Purchase the vragenlijst based on the given parameter.
     * @param currentVragenlijst
     * @return boolean, whether the transaction was succesful or not.
     */
    public boolean buyVragenlijst(int currentVragenlijst) {
        currentVragenlijst -= 1;
        if (currentVragenlijst >= 0 && currentVragenlijst < winkel.getVragenlijst().size()) {
            Vragenlijst vragenlijst = winkel.getVragenlijst().get(currentVragenlijst);
            if (!User.getCurrentUser().hasVragenlijst(vragenlijst) &&!User.getCurrentUser().expired(vragenlijst)) {
                if (User.getCurrentUser().verminderSaldo(vragenlijst.getPrijs())) {
                    User.getCurrentUser().addVragenlijst(vragenlijst);
                    winkelView.successful(vragenlijst.getPrijs(), User.getCurrentUser().getSaldo());
                    return true;
                } else {
                    winkelView.insufficient();
                    return false;
                }
            } else {
                winkelView.duplicate();
                return false;
            }
        } else {
            winkelView.invalid();
            return false;
        }
    }

    /**
     * Message to be displayed after succesful transaction
     */
    public void choice() {
        winkelView.choice();
    }

    /**
     * Message to let the user know it can leave anytime
     */
    public void leaveMessage() {
        winkelView.leave();
    }

    /**
     * Message to be displayed when user leaves the shop.
     */
    public void exitMessage() {
        winkelView.exit();
    }
}
