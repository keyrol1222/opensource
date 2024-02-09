package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Empleados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Empleados
@RestController
@RequestMapping("/empleados")
public class ControladoraEmpleados {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraEmpleados (PersistenceService con) {
        
        this.con = con;
    }
    
    @PostMapping("/empleados/create")
    public void CrearEmpleados(@RequestBody Empleados em){
        
        con.CrearEmpleado(em);
        
    }
    
    @PutMapping("/empleados")
    public void EditarEmpleados(Empleados em){
        
        con.EditarEmpleado(em);        
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimEmpleados(@PathVariable("id") Long id){
        
        con.ElimEmpleado(id);
    }
    
    @GetMapping("/empleados")
    public List<Empleados> obtenerEmpleados(){
        return con.obtenerEmpleado();
    }
    
    @GetMapping("/empleados/{id}")
    public Optional<Empleados> obtenerEmpleados(@PathVariable("id") Long id){
        return con.obtenerEmpleado(id);
    }
    
}
