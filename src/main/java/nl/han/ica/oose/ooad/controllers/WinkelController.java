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

    public void getWelcome() {
        winkelView.welcome();
    }

    public void displayThemaList() {
        winkelView.displayThema();
    }

    public boolean pickThema(int num) {
        if (num < 0 || num > winkel.getThemaList().size()) {
            winkelView.invalid();
            return false;
        } else {
            winkel.setCurrentThema(num);
            return true;
        }
    }

    public boolean pickOnderwerp(int num) {
        if (num < 0 || num > winkel.getOnderwerpList().size()) {
            winkelView.invalid();
            return false;
        } else {
            winkel.setCurrentOnderwerp(num);
            return true;
        }
    }

    public void displayOnderwerpList() {
        winkelView.displayOnderwerpList();
    }

    public void displayVragenlijst() {
        winkelView.displayVragenlijst();
    }


    public boolean buyVragenlijst(int currentVragenlijst) {
        currentVragenlijst -= 1;
        if (currentVragenlijst >= 0 && currentVragenlijst < winkel.getVragenlijst().size()) {
            Vragenlijst vragenlijst = winkel.getVragenlijst().get(currentVragenlijst);
            if (!User.getCurrentUser().expired(vragenlijst)) {
                if (User.getCurrentUser().verminderSaldo(vragenlijst.getPrijs())) {
                    User.getCurrentUser().addVragenlijst(vragenlijst);
                    winkelView.successfull(vragenlijst.getPrijs(), User.getCurrentUser().getSaldo());
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

    public void choice() {
        winkelView.choice();
    }

    public void leaveMessage() {
        winkelView.leave();
    }

    public void exitMessage() {
        winkelView.exit();
    }
}
