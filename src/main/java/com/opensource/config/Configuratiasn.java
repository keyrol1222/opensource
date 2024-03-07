package com.opensource.config;

import com.opensource.Database.Articulo;
import com.opensource.Persistence.ArticuloJpaController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuratiasn {
    
    @Bean
    CommandLineRunner commandLineRunner(ArticuloJpaController repository){
        return args -> {
            Articulo mariam = new Articulo(
                    
            );

            repository.save(
                    mariam
            );
        };
    }
    
}
