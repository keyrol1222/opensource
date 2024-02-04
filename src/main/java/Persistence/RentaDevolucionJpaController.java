package Persistence;


import com.opensource.Database.RentaDevolucion;
import org.springframework.data.jpa.repository.JpaRepository;

//Controladora de la tabla Renta-Devolucion
public interface RentaDevolucionJpaController 
        extends JpaRepository<RentaDevolucion, Long>{        
}
