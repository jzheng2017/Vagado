package nl.han.ica.oose.ooad.models.users;

import nl.han.ica.oose.ooad.managers.UserManager;

public class Register {
    private String username;
    private String password;

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUsernameTaken(){
        return UserManager.getInstance().getByUsername(username) != null;
    }
}
