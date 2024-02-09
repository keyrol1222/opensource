package com.opensource.Persistence;


import com.opensource.Database.Elenco;
import org.springframework.data.jpa.repository.JpaRepository;


//Controladora de la tabla Elenco
public interface ElencoJpaController  
        extends JpaRepository<Elenco, Long>{
    
    
}
