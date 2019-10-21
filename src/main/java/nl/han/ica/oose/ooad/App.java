package nl.han.ica.oose.ooad;

public class App {
    private StateMachine stateMachine = new StateMachine();

    public App(){

    }

    public void start(){
        while (true) {
            stateMachine.execute();
        }
    }
}
