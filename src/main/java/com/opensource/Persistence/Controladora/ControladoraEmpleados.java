package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Empleados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Empleados
@CrossOrigin
@RestController
@RequestMapping("/empleados")
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
    
    @PutMapping
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
    
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Optional<Empleados>> obtenerEmpleados(@PathVariable("id") Long id){
        
        Optional<Empleados> e = con.obtenerEmpleado(id);
        
        if (e != null) {
            // Si se encuentra el producto, devolverlo con el código de estado 200 OK
            return ResponseEntity.ok(e);
        } else {
            // Si no se encuentra el producto, devolver un código de estado 404 Not Found
            return ResponseEntity.notFound().build();
        }  
    }
    
}
