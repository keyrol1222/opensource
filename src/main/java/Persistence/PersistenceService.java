package Persistence;

import com.opensource.Database.Articulo;
import com.opensource.Database.Clientes;
import com.opensource.Database.Elenco;
import com.opensource.Database.Empleados;
import com.opensource.Database.Generos;
import com.opensource.Database.Idiomas;
import com.opensource.Database.RentaDevolucion;
import com.opensource.Database.TiposArticulos;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Service;

@Service
public class ContPersistence {
    
    ArticuloJpaController AC;
    
    ClientesJpaController CC;
    
    ElencoJpaController EC;
    
    EmpleadosJpaController EmC;
    
    GenerosJpaController GC;
    
    IdiomasJpaController IC;
    
    RentaDevolucionJpaController RC;
    
    TiposArticulosJpaController TAC;
    
    
    public void CrearArticulo(Articulo a){
        
        AC.create(a);
        
    }
    
    public void EditarArticulo(Articulo a){
        
        try {
            AC.edit(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimArticulo(Articulo a){
        
        AC.create(a);
        
    }
    
    public ArrayList<Articulo> obtenerArticulo(){
        List<Articulo> articulo = AC.findArticuloEntities();
        ArrayList<Articulo> ArticuloList = new ArrayList<>(articulo);
        return ArticuloList;
    }
    
    public Articulo obtenerArticulo(int id){
        Articulo articulo = AC.findArticulo(id);
        return articulo;
    }
    
    
    public void CrearClientes(Clientes c){
        
        CC.create(c);
        
    }
    
    public void EditarClientes(Clientes c){
        
        try {
            CC.edit(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimClientes(Clientes c){
        
        CC.create(c);
        
    }
    
    public ArrayList<Clientes> obtenerClientes(){
        List<Clientes> Clientes = CC.findClientesEntities();
        ArrayList<Clientes> ClientesList = new ArrayList<>(Clientes);
        return ClientesList;
    }
    
    public Clientes obtenerClientes(int id){
        Clientes Clientes = CC.findClientes(id);
        return Clientes;
    }
    
    public void CrearElenco(Elenco e){
        
        EC.create(e);
        
    }
    
    public void EditarElenco(Elenco e){
        
        try {
            EC.edit(e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimElenco(Elenco e){
        
        EC.create(e);
        
    }
    
    public ArrayList<Elenco> obtenerElenco(){
        List<Elenco> elenco = EC.findElencoEntities();
        ArrayList<Elenco> ElencoList = new ArrayList<>(elenco);
        return ElencoList;
    }
    
    public Elenco obtenerElenco(int id){
        Elenco elenco = EC.findElenco(id);
        return elenco;
    }
    
    
    public void CrearEmpleados(Empleados em){
        
        EmC.create(em);
        
    }
    
    public void EditarEmpleados(Empleados em){
        
        try {
            EmC.edit(em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimEmpleados(Empleados em){
        
        EmC.create(em);
        
    }
    
    public ArrayList<Empleados> obtenerEmpleados(){
        List<Empleados> empleados = EmC.findEmpleadosEntities();
        ArrayList<Empleados> EmpleadosList = new ArrayList<>(empleados);
        return EmpleadosList;
    }
    
    public Empleados obtenerEmpleados(int id){
        Empleados empleados = EmC.findEmpleados(id);
        return empleados;
    }
    
    
    public void CrearGeneros(Generos g){
        
        GC.create(g);
        
    }
    
    public void EditarGeneros(Generos g){
        
        try {
            GC.edit(g);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimGeneros(Generos g){
        
        GC.create(g);
        
    }
    
    public ArrayList<Generos> obtenerGeneros(){
        List<Generos> generos = GC.findGenerosEntities();
        ArrayList<Generos> GenerosList = new ArrayList<>(generos);
        return GenerosList;
    }
    
    public Generos obtenerGeneros(int id){
        Generos generos = GC.findGeneros(id);
        return generos;
    }
    
    
    
    public void CrearIdiomas(Idiomas i){
        
        IC.create(i);
        
    }
    
    public void EditarIdiomas(Idiomas i){
        
        try {
            IC.edit(i);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimIdiomas(Idiomas i){
        
        IC.create(i);
        
    }
    
    public ArrayList<Idiomas> obtenerIdiomas(){
        List<Idiomas> idiomas = IC.findIdiomasEntities();
        ArrayList<Idiomas> ArticuloList = new ArrayList<>(idiomas);
        return ArticuloList;
    }
    
    public Idiomas obtenerIdiomas(int id){
        Idiomas idiomas = IC.findIdiomas(id);
        return idiomas;
    }
    
    
    public void CrearRentaDevolucion(RentaDevolucion rd){
        
        RC.create(rd);
        
    }
    
    public void EditarRentaDevolucion(RentaDevolucion rd){
        
        try {
            RC.edit(rd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimRentaDevolucion(RentaDevolucion rd){
        
        RC.create(rd);
        
    }
    
    public ArrayList<RentaDevolucion> obtenerRentaDevolucion(){
        List<RentaDevolucion> RD = RC.findRentaDevolucionEntities();
        ArrayList<RentaDevolucion> RDList = new ArrayList<>(RD);
        return RDList;
    }
    
    public RentaDevolucion obtenerRentaDevolucion(int id){
        RentaDevolucion RD = RC.findRentaDevolucion(id);
        return RD;
    }
    
    
    public void CrearTiposArticulos(TiposArticulos ta){
        
        TAC.create(ta);
        
    }
    
    public void EditarTiposArticulos(TiposArticulos ta){
        
        try {
            TAC.edit(ta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Hubo un problema en editar", "advertencia", HEIGHT);
        }
        
    }
        
    
    public void ElimTiposArticulos(TiposArticulos ta){
        
        TAC.create(ta);
        
    }
    
    public ArrayList<TiposArticulos> obtenerTiposArticulos(){
        List<TiposArticulos> ta = TAC.findTiposArticulosEntities();
        ArrayList<TiposArticulos> TAList = new ArrayList<>(ta);
        return TAList;
    }
    
    public TiposArticulos obtenerTiposArticulos(int id){
        TiposArticulos ta = TAC.findTiposArticulos(id);
        return ta;
    }
}
