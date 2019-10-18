package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.models.game.Quiz;
import nl.han.ica.oose.ooad.models.users.User;
import nl.han.ica.oose.ooad.models.vragen.Vragenlijst;
import nl.han.ica.oose.ooad.models.vragen.VragenlijstCollection;
import nl.han.ica.oose.ooad.views.MeerkeuzeVraagView;
import nl.han.ica.oose.ooad.views.OpenVraagView;
import nl.han.ica.oose.ooad.views.QuizSelectionView;

public class QuizController extends Controller {
    private VragenlijstCollection vragenlijstCollection;
    private Vragenlijst vragenlijst;
    private OpenVraagView openVraagView;
    private MeerkeuzeVraagView meerkeuzeVraagView;

    public QuizController(){
        setType(ControllerType.Quiz);
    }
    @Override
    boolean authorized() {
        return User.loggedIn();
    }

    public int startSelection() {
        if (authorized()) {
            QuizSelectionView quizSelectionView = new QuizSelectionView(vragenlijstCollection);

            quizSelectionView.display();
            return 0;
        } else {
            System.out.println("Je mag deze actie niet uitvoeren.");
            return 2;
        }
    }

    public void setVragenlijstCollection(VragenlijstCollection vragenlijstCollection) {
        this.vragenlijstCollection = vragenlijstCollection;
    }

    public boolean startQuiz() {
        Quiz.setCurrentQuiz(new Quiz(vragenlijst.getVragen(10), User.getCurrentUser()));
        return true;
    }

    public void playQuiz() {
        while (Quiz.getCurrentQuiz().isPlaying()) {

        }
    }
}
