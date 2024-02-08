
package Persistence.Controladora;

import Persistence.PersistenceService;
import com.opensource.Database.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Clientes
@RestController
@RequestMapping("/Clientes")
public class ControladoraClientes {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraClientes (PersistenceService con) {
        
        this.con = con;
    }
    
    
    
    @PostMapping
    public void CrearClientes(Clientes c){
        
        con.CrearCliente(c);        
    }
    
    
    public void EditarClientes(Clientes c){
        
        con.EditarCliente(c);       
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimClientes(@PathVariable("id") Long id){
        
        con.ElimCliente(id);        
    }
    
    @GetMapping
    public List<Clientes> obtenerClientes(){
        
        return con.obtenerCliente();
    }
    
    
    
    public Optional<Clientes> obtenerClientes(Long id){
        
        return con.obtenerCliente(id);
    }
    
}