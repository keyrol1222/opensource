package com.opensource.Persistence;

import com.opensource.Database.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla articulo
@Repository
public interface ArticuloJpaController 
        extends JpaRepository<Articulo, Long>{
       
}
