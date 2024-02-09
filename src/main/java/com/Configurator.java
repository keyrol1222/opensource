package com;

import com.opensource.Database.Generos;
import com.opensource.Persistence.GenerosJpaController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerosConfig {
    
    @Bean
    CommandLineRunner papa(GenerosJpaController repository){
        return args -> {
            Generos mariam = new Generos(
                    "Mariam",
                    "mariam.jamal@gmail.com"                    
            );

            repository.save(
                    mariam
            );
        };
    }
    
}
