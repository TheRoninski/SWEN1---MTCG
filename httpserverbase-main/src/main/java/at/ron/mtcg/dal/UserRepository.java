package at.ron.mtcg.dal;

import at.ron.mtcg.model.Users;
import java.util.HashMap;


public class UserRepository {
    private static UserRepository Instance = null;
    private HashMap<String, Users> database = new HashMap<>();
    public UserRepository() {
    }

    public static UserRepository getInstance() {
        if (Instance == null) {
            Instance = new UserRepository();
        }
        return Instance;
    }

    public Users getUser(String username) {
        return database.get(username);
    }


    public boolean register(Users user) {
        if (database.containsKey(user.getUsername())) {
            return false;
        }
        database.put(user.getUsername(), user);
        return true;
    }

    public void updateUser(Users user) {
        database.put(user.getUsername(), user);
    }
}
