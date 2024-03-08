package com.opensource.Persistence;


import com.opensource.Database.RentaDevolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla Renta-Devolucion
@Repository
public interface RentaDevolucionJpaController 
        extends JpaRepository<RentaDevolucion, Long>{        
}
