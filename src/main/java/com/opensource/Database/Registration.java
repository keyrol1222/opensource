package com.opensource.Database;

import lombok.Data;

@Data
public class Registration {
    
    private String username;
    private String password;

    public Registration(){
        super();
    }

    public Registration(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }


    
}
