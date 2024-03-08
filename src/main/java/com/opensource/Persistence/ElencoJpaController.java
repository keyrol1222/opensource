package com.opensource.Persistence;


import com.opensource.Database.Elenco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Controladora de la tabla Elenco
@Repository
public interface ElencoJpaController  
        extends JpaRepository<Elenco, Long>{
    
    
}
