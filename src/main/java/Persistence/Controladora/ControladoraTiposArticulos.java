package Persistence.Controladora;

import Persistence.PersistenceService;
import com.opensource.Database.TiposArticulos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Controladora donde se pueden acceder a los metodos de TiposArticulos
@RestController
@RequestMapping("/TiposArticulos")
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
    
    
    public Optional<TiposArticulos> obtenerTiposArticulos(Long id){
        return con.obtenerTiposArticulo(id);
    }
    
}
