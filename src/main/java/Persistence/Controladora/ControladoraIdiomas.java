
package Persistence.Controladora;

import Persistence.PersistenceService;
import com.opensource.Database.Idiomas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Idiomas
@RestController
@RequestMapping("/Idiomas")
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
    
    
    public Optional<Idiomas> obtenerIdiomas(Long id){
        return con.obtenerIdioma(id);
    }
    
}
