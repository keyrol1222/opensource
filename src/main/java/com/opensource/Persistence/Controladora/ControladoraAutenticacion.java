package com.opensource.Persistence.Controladora;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JwtUtils;
import com.opensource.Persistence.Usuarios.AuthenticationRequest;
import com.opensource.Persistence.Usuarios.RepositorioUsuarios;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/idiomas")
@RequiredArgsConstructor
public class ControladoraAutenticacion {

    private final AuthenticationManager authenticationManager;
    private final RepositorioUsuarios repositorioUsuarios;
    private final JwtUtils jwtUtils;

    @PostMapping ("/autenticacion")
    public ResponseEntity<String> authenticate(
      @RequestBody AuthenticationRequest request
    ) {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
      );
      final UserDetails user = repositorioUsuarios.findUserByEmail(request.getEmail());
      if (user != null) {
         return ResponseEntity.ok(jwtUtils.generateToken(user));
      }
      return ResponseEntity.status(400).body("Ocurrio un error");
    }
}
