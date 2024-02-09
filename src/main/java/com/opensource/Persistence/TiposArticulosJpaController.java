package com.opensource.Persistence;


import com.opensource.Database.TiposArticulos;
import org.springframework.data.jpa.repository.JpaRepository;


//Controladora de la tabla TiposArticulos
public interface TiposArticulosJpaController 
        extends JpaRepository<TiposArticulos, Long>{
}
