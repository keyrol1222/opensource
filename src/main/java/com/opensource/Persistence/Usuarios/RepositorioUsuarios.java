package com.opensource.Persistence.Usuarios;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarios {
        private final static List<UserDetails> APPLICATION_USERS = Arrays.asList( 
        new User(
            "videoclub.proyecto@gmail.com",
            "contraseña",
            Collections.singleton(new SimpleGrantedAuthority("ADMIN"))
        ),
        new User(
            "cliente.proyecto@gmail.com",
            "contraseña",
            Collections.singleton(new SimpleGrantedAuthority("CLIENTE"))
        )
    );

    public static UserDetails findUserByEmail(String email) {
            return APPLICATION_USERS
            .stream()
            .filter(u -> u.getUsername().equals(email))
            .findFirst()
            .orElseThrow(()-> new UsernameNotFoundException("No se encontraron resultados"));
    }
}
