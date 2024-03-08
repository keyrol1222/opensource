package com.opensource.Persistence.Controladora;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class ControladoraAutenticacion {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
