
package com.opensource.Persistence;


import com.opensource.Database.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

//Controladora de la tabla Empleados
public interface EmpleadosJpaController 
        extends JpaRepository<Empleados, Long>{ 
}
