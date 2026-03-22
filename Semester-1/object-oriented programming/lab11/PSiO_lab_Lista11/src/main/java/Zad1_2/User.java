package Zad1_2;

import java.util.regex.Pattern;

public class User {
    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !Pattern.matches("^.+@.+$", email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}