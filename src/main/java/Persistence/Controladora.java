package Persistence;

import com.opensource.Database.*;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


//Controladora donde se pueden acceder a los metodos de la ContPersistence
@RestController
public class Controladora {

    private final PersistenceService con;
    
    @Autowired
    public Controladora(PersistenceService con) {
        
        this.con = con;
    }
    
    
    public void CrearArticulos(Articulo a){
        
        con.CrearArticulo(a);        
    }
    
    public void EditarArticulos(Articulo a){
            con.EditarArticulo(a);
    }
        
    
    public void ElimArticulos(int id){
        
        con.ElimArticulo(id);       
    }
    
    
    public ArrayList<Articulo> obtenerArticulos(){
        
        return con.obtenerArticulo();
    }
    
    
    public Articulo obtenerArticulos(int id){        
        return con.obtenerArticulo(id);
    }
    
    
    public void CrearClientes(Clientes c){
        
        con.CrearCliente(c);        
    }
    
    
    public void EditarClientes(Clientes c){
        
        con.EditarCliente(c);       
    }
        
    
    public void ElimClientes(int id){
        
        con.ElimCliente(id);        
    }
    
    
    public ArrayList<Clientes> obtenerClientes(){
        
        return con.obtenerCliente();
    }
    
    
    
    public Clientes obtenerClientes(int id){
        
        return con.obtenerCliente(id);
    }
    
    
    public void CrearElencos(Elenco e){
        
        con.CrearElenco(e);
        
    }
    
    
    public void EditarElencos(Elenco e){
        
        con.EditarElenco(e);
        
    }
        
    
    public void ElimElencos(int id){
        
        con.ElimElenco(id);
        
    }
    
    
    public ArrayList<Elenco> obtenerElencos(){
        
        return con.obtenerElenco();
    }
    
    
    public Elenco obtenerElencos(int id){
        
        return con.obtenerElenco(id);
    }
    
    
    public void CrearEmpleados(Empleados em){
        
        con.CrearEmpleado(em);
        
    }
    
    
    public void EditarEmpleados(Empleados em){
        
        con.EditarEmpleado(em);        
    }
        
    
    public void ElimEmpleados(int id){
        
        con.ElimEmpleado(id);
    }
    
    
    public ArrayList<Empleados> obtenerEmpleados(){
        return con.obtenerEmpleado();
    }
    
    
    public Empleados obtenerEmpleados(int id){
        return con.obtenerEmpleado(id);
    }
    
    
    public void CrearGeneros(Generos g){
        
        con.CrearGenero(g);
        
    }
    
    
    public void EditarGeneros(Generos g){
        
        con.EditarGenero(g);        
    }
        
    
    public void ElimGeneros(int id){
        
        con.ElimGenero(id);
    }
    
    
    public ArrayList<Generos> obtenerGeneros(){
        return con.obtenerGenero();
    }
    
    
    public Generos obtenerGeneros(int id){
        return con.obtenerGenero(id);
    }
    
    
    
    public void CrearIdiomas(Idiomas i){
        
        con.CrearIdioma(i);
        
    }
    
    
    public void EditarIdiomas(Idiomas i){
        
        con.EditarIdioma(i);
    }
        
    
    public void ElimIdiomas(int id){
        
        con.ElimIdioma(id);
        
    }
    
    
    public ArrayList<Idiomas> obtenerIdiomas(){
        return con.obtenerIdioma();
    }
    
    
    public Idiomas obtenerIdiomas(int id){
        return con.obtenerIdioma(id);
    }
    
    
    public void CrearRentaDevoluciones(RentaDevolucion rd){
        
        con.CrearRentaDevolucion(rd);
        
    }
    
    
    public void EditarRentaDevoluciones(RentaDevolucion rd){
        
        con.EditarRentaDevolucion(rd);        
    }
        
    
    public void ElimRentaDevoluciones(int id){
        
        con.ElimRentaDeolucion(id);
        
    }
    
    
    public ArrayList<RentaDevolucion> obtenerRentaDevoluciones(){
        return con.obtenerRentaDevolucion();
    }
    
    
    public RentaDevolucion obtenerRentaDevoluciones(int id){
        return con.obtenerRentaDevolucion(id);
    }
    
    
    public void CrearTiposArticulos(TiposArticulos ta){
        
        con.CrearTiposArticulo(ta);        
    }
    
    
    public void EditarTiposArticulos(TiposArticulos ta){
        
        con.EditarTiposArticulo(ta);
        
    }
        
    
    public void ElimTiposArticulos(int id){
        
        con.ElimTiposArticulos(id);        
    }
    
    
    public ArrayList<TiposArticulos> obtenerTiposArticulos(){
        return con.obtenerTiposArticulo();
    }
    
    
    public TiposArticulos obtenerTiposArticulos(int id){
        return con.obtenerTiposArticulo(id);
    }
    
}
