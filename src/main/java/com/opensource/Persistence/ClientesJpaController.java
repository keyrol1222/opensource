
package com.opensource.Persistence;


import com.opensource.Database.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla clientes
@Repository
public interface ClientesJpaController 
        extends JpaRepository<Clientes, Long>{
    
}
