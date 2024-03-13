package com.opensource.config;

import com.opensource.Database.*;
import com.opensource.Persistence.*;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Configurator {
    
    @Bean
    CommandLineRunner Genero(GenerosJpaController repository){
        return args -> {
            Generos m = new Generos(
                    "Accion",
                    "Activo"                    
            );

            repository.save(
                    m
            );
        };
    }
    
    @Bean
    CommandLineRunner Elenco(ElencoJpaController repository){
        return args -> {
            Elenco m = new Elenco(
                    "Arnold Schwarzenegger",
                    "Retirado"                    
            );

            repository.save(
                    m
            );
        };
    }
    
    @Bean
    CommandLineRunner Idiomas(IdiomasJpaController repository){
        return args -> {
            Idiomas m = new Idiomas(
                    "ingles",
                    "Activo"                    
            );

            repository.save(
                    m
            );
        };
    }
    
    @Bean
    CommandLineRunner Tipos(TiposArticulosJpaController repository){
        return args -> {
            TiposArticulos m = new TiposArticulos(
                    "Digital",
                    "Activo"                    
            );

            repository.save(
                    m
            );
        };
    }
    
    @Bean
    CommandLineRunner articulo(ArticuloJpaController repository){
        return args -> {
            Articulo m = new Articulo(
                    "Matrix", 
                    null, 
                    null, 
                    0, 0, 0, 
                    "Disponible"
            );

            repository.save(
                    m
            );
        };
    }
    	@Bean
	CommandLineRunner usuario(RoleJpaController roleRepository, UserJpaController userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			Usuario admin = new Usuario(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
    
}
