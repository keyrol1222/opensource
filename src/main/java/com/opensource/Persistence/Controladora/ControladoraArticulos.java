package com.opensource.Persistence.Controladora;

import com.opensource.Database.Articulo;
import com.opensource.Persistence.PersistenceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Articulos
@CrossOrigin
@RestController
@RequestMapping("/articulos")
public class ControladoraArticulos {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraArticulos (PersistenceService con) {
        
        this.con = con;
    }
    
    @PostMapping
    public void CrearArticulos(@RequestBody Articulo a){
        
        con.CrearArticulo(a);        
    }
    
    @PutMapping
    public void EditarArticulos(Articulo a){
            con.EditarArticulo(a);
    }
        
    @DeleteMapping("/articulos/{id}")
    public void ElimArticulos(@PathVariable("id") Long id){
        
        con.ElimArticulo(id);       
    }
    
    @GetMapping
    public List<Articulo> obtenerArticulos(){
        
        return con.obtenerArticulo();
    }
    
    @GetMapping("/articulos/{id}")
    public Optional<Articulo> obtenerArticulos(@PathVariable("id") Long id){        
        return con.obtenerArticulo(id);
    }
    
}
