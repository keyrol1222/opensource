package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Idiomas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Idiomas
@CrossOrigin
@RestController
@RequestMapping("/idiomas")
public class ControladoraIdiomas {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraIdiomas (PersistenceService con) {
        
        this.con = con;
    }
    
    
    
    @PostMapping
    public void CrearIdiomas(@RequestBody Idiomas i){
        
        con.CrearIdioma(i);
        
    }
    
    @PutMapping
    public void EditarIdiomas(Idiomas i){
        
        con.EditarIdioma(i);
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimIdiomas(@PathVariable("id") Long id){
        
        con.ElimIdioma(id);
        
    }
    
    @GetMapping
    public List<Idiomas> obtenerIdiomas(){
        return con.obtenerIdioma();
    }
    
    @GetMapping("/idiomas/{id}")
    public Optional<Idiomas> obtenerIdiomas(@PathVariable("id") Long id){
        return con.obtenerIdioma(id);
    }
    
}
