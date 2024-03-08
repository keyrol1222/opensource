package com.opensource.Persistence;


import com.opensource.Database.TiposArticulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Controladora de la tabla TiposArticulos
@Repository
public interface TiposArticulosJpaController 
        extends JpaRepository<TiposArticulos, Long>{
}
