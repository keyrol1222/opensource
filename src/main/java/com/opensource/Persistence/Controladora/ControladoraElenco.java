package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Elenco;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Elenco
@CrossOrigin
@RestController
@RequestMapping("/elenco")
public class ControladoraElenco {
    
        private final PersistenceService con;
    
    @Autowired
    public ControladoraElenco (PersistenceService con) {
        
        this.con = con;
    }
    
    @PostMapping
    public void CrearElencos(@RequestBody Elenco e){
        
        con.CrearElenco(e);
        
    }
    
    @PutMapping
    public void EditarElencos(Elenco e){
        
        con.EditarElenco(e);
        
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimElencos(@PathVariable("id") Long id){
        
        con.ElimElenco(id);
        
    }
    
    @GetMapping
    public List<Elenco> obtenerElencos(){
        
        return con.obtenerElenco();
    }
    
    @GetMapping("/elenco/{id}")
    public Optional<Elenco> obtenerElencos(@PathVariable("id") Long id){
        
        return con.obtenerElenco(id);
    }
    
}
