package nl.han.ica.oose.ooad.models.users;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager userManager;
    private List<User> userList;

    private UserManager() {
        userList = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

    public boolean remove(User user) {
        return userList.remove(user);
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getByUsername(String username) {
        return userList.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }
}

