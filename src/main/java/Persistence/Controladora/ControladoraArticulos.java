package Persistence.Controladora;

import Persistence.PersistenceService;
import com.opensource.Database.Articulo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Articulos
@RestController
@RequestMapping("/Articulos")
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
    
    public void EditarArticulos(Articulo a){
            con.EditarArticulo(a);
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimArticulos(@PathVariable("id") Long id){
        
        con.ElimArticulo(id);       
    }
    
    @GetMapping
    public List<Articulo> obtenerArticulos(){
        
        return con.obtenerArticulo();
    }
    
    
    public Optional<Articulo> obtenerArticulos(Long id){        
        return con.obtenerArticulo(id);
    }
    
}
