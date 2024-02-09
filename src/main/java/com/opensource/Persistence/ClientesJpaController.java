
package com.opensource.Persistence;


import com.opensource.Database.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

//Controladora de la tabla clientes
public interface ClientesJpaController 
        extends JpaRepository<Clientes, Long>{
    
}
