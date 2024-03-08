
package com.opensource.Persistence;


import com.opensource.Database.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controladora de la tabla Empleados
@Repository
public interface EmpleadosJpaController 
        extends JpaRepository<Empleados, Long>{ 
}
