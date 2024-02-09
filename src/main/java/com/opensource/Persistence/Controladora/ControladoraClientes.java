package com.opensource.Persistence.Controladora;

import com.opensource.Persistence.PersistenceService;
import com.opensource.Database.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controladora donde se pueden acceder a los metodos de Clientes
@RestController
@RequestMapping("/clientes")
public class ControladoraClientes {
    
    private final PersistenceService con;
    
    @Autowired
    public ControladoraClientes (PersistenceService con) {
        
        this.con = con;
    }
    
    @PostMapping("/clientes/create")
    public void CrearClientes(Clientes c){
        
        con.CrearCliente(c);        
    }
    
    @PutMapping("/clientes")
    public void EditarClientes(Clientes c){
        
        con.EditarCliente(c);       
    }
        
    @DeleteMapping(path = "{id}")
    public void ElimClientes(@PathVariable("id") Long id){
        
        con.ElimCliente(id);        
    }
    
    @GetMapping("/clientes")
    public List<Clientes> obtenerClientes(){
        
        return con.obtenerCliente();
    }
    
    
    @GetMapping("/Clientes/{id}")
    public Optional<Clientes> obtenerClientes(@PathVariable("id") Long id){
        
        return con.obtenerCliente(id);
    }
    
}
