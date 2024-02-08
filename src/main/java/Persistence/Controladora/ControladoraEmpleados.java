package Persistence.Controladora;

import Persistence.PersistenceService;
import com.opensource.Database.Empleados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Empleados
@RestController
@RequestMapping("/Empleados")
public class ControladoraEmpleados {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraEmpleados (PersistenceService con) {
        
        this.con = con;
    }
    
    @PostMapping
    public void CrearEmpleados(@RequestBody Empleados em){
        
        con.CrearEmpleado(em);
        
    }
    
    
    public void EditarEmpleados(Empleados em){
        
        con.EditarEmpleado(em);        
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimEmpleados(@PathVariable("id") Long id){
        
        con.ElimEmpleado(id);
    }
    
    @GetMapping
    public List<Empleados> obtenerEmpleados(){
        return con.obtenerEmpleado();
    }
    
    
    public Optional<Empleados> obtenerEmpleados(Long id){
        return con.obtenerEmpleado(id);
    }
    
}
