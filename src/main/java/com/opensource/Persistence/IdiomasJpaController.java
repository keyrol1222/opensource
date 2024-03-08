package com.opensource.Persistence;


import com.opensource.Database.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla Idiomas
//Si se quiere utilizar algunas de estas funciones, favor usar las funciones de la clase ContPersitence
@Repository
public interface IdiomasJpaController 
        extends JpaRepository<Idiomas, Long>{
        
}
