package com.opensource.Persistence;


import com.opensource.Database.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla Generos
@Repository
public interface GenerosJpaController 
        extends JpaRepository<Generos, Long>{     
}
