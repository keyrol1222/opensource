package com.opensource.Database;

import lombok.Data;

@Data
public class LoginResponse {
    
    private Usuario user;
    private String jwt;

    public LoginResponse(){
        super();
    }

    public LoginResponse(Usuario user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public Usuario getUser(){
        return this.user;
    }
    
    
}
