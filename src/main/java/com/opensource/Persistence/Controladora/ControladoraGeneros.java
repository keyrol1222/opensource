package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Generos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Generos
@RestController
@RequestMapping("/generos")
public class ControladoraGeneros {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraGeneros (PersistenceService con) {
        
        this.con = con;
    }
    
    
    @PostMapping("/generos/create")
    public void CrearGeneros(@RequestBody Generos g){
        
        con.CrearGenero(g);
        
    }
    
    @PutMapping("/generos")
    public void EditarGeneros(Generos g){
        
        con.EditarGenero(g);        
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimGeneros(@PathVariable("id") Long id){
        
        con.ElimGenero(id);
    }
    
    @GetMapping("/generos")
    public List<Generos> obtenerGeneros(){
        return con.obtenerGenero();
    }
    
    @GetMapping("/generos/{id}")
    public Optional<Generos> obtenerGeneros(@PathVariable("id") Long id){
        return con.obtenerGenero(id);
    }
    
}
