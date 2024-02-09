package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Generos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Generos
@CrossOrigin
@RestController
@RequestMapping("/Generos")
public class ControladoraGeneros {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraGeneros (PersistenceService con) {
        
        this.con = con;
    }
    
    
    @PostMapping
    public void CrearGeneros(@RequestBody Generos g){
        
        con.CrearGenero(g);
        
    }
    
    @PutMapping
    public void EditarGeneros(Generos g){
        
        con.EditarGenero(g);        
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimGeneros(@PathVariable("id") Long id){
        
        con.ElimGenero(id);
    }
    
    @GetMapping
    public List<Generos> obtenerGeneros(){
        return con.obtenerGenero();
    }
    
    
    public Optional<Generos> obtenerGeneros(Long id){
        return con.obtenerGenero(id);
    }
    
}
