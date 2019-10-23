package nl.han.ica.oose.ooad.views;

import nl.han.ica.oose.ooad.models.users.Register;

public class RegisterView {
    private Register register;

    public RegisterView(Register register){
        this.register = register;
    }

    public void successful(){
        System.out.println("Je bent succesvol geregistreerd!");
        System.out.println("Logingegevens:");
        System.out.println("Username: " + register.getUsername());
        System.out.println("Password: " + register.getPassword());
    }

    public void taken(){
        System.out.println("Jouw gekozen username [" + register.getUsername() + "] is al in gebruik. Kies een andere username.");
    }
}
