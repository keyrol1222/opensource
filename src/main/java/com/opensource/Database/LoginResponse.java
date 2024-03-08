package com.opensource.Database;

import lombok.Data;

@Data
public class LoginResponse {
    
    private User user;
    private String jwt;

    public LoginResponse(){
        super();
    }

    public LoginResponse(User user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser(){
        return this.user;
    }
    
    
}
