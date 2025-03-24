package com.example.model;



import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String password_hash;

    // Getters and Setters
    public int getUserId() { return user_id; }
    public void setUserId(int user_id) { this.user_id = user_id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return password_hash; }
    public void setPasswordHash(String password_hash) { this.password_hash = password_hash; }
}