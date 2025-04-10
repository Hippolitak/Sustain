package com.example.sustain;

// Registers a new user if passwords match and username is unique
public class User {
    private String firstName;
    private String lastName;
    private String password;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
