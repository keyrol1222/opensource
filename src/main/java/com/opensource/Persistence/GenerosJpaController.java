package com.opensource.Persistence;


import com.opensource.Database.Generos;
import org.springframework.data.jpa.repository.JpaRepository;

//Controladora de la tabla Generos
public interface GenerosJpaController 
        extends JpaRepository<Generos, Long>{     
}
