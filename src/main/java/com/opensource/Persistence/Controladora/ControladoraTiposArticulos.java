package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.TiposArticulos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Controladora donde se pueden acceder a los metodos de TiposArticulos
@CrossOrigin
@RestController
@RequestMapping("/tiparticulos")
public class ControladoraTiposArticulos {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraTiposArticulos (PersistenceService con) {
        
        this.con = con;
    }
    

    
    @PostMapping
    public void CrearTiposArticulos(@RequestBody TiposArticulos ta){
        
        con.CrearTiposArticulo(ta);        
    }
    
    @PutMapping
    public void EditarTiposArticulos(TiposArticulos ta){
        
        con.EditarTiposArticulo(ta);        
    }
      
    
    @DeleteMapping(path = "{id}")
    public void ElimTiposArticulos(@PathVariable("id") Long id){
        
        con.ElimTiposArticulos(id);        
    }
    
    @GetMapping 
    public List<TiposArticulos> obtenerTiposArticulos(){
        return con.obtenerTiposArticulo();
    }
    
    @GetMapping("/tiparticulos/{id}")    
    public Optional<TiposArticulos> obtenerTiposArticulos(@PathVariable("id") Long id){
        return con.obtenerTiposArticulo(id);
    }
    
}
