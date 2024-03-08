package com.opensource.Persistence.Controladora;

import com.opensource.Database.LoginResponse;
import com.opensource.Database.Registration;
import com.opensource.Database.User;
import com.opensource.Persistence.AuthenticationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class ControladoraAutenticacion {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody Registration body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody Registration body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
