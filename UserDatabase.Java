package com.example.sustain;

import java.util.HashMap;

// Manages a HashMap of users, supporting validation, registration, and existence checks
public class UserDatabase {

    private static HashMap<String, User> users = new HashMap<>();

    static {
        users.put("test", new User("Test", "User", "password123"));
        users.put("admin", new User("Admin", "Account", "adminpass"));
    }

    public static boolean validateLogin(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public static void registerUser(String username, User user) {
        users.put(username, user);
    }

    public static boolean userExists(String username) {
        return users.containsKey(username);
    }
}
