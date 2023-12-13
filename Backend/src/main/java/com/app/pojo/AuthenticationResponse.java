package com.app.pojo;

public class AuthenticationResponse {
    private String token;
    private Users user;  // Assuming Users is the class representing user information

    public AuthenticationResponse(String token, Users user) {
        this.token = token;
        this.user = user;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
