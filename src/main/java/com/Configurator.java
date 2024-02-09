package com;

import com.opensource.Database.*;
import com.opensource.Persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    
}
