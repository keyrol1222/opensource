package com.opensource.Persistence;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opensource.Database.Articulo;
import com.opensource.Database.Clientes;
import com.opensource.Database.Elenco;
import com.opensource.Database.Empleados;
import com.opensource.Database.Generos;
import com.opensource.Database.Idiomas;
import com.opensource.Database.RentaDevolucion;
import com.opensource.Database.TiposArticulos;

@RestController
@RequestMapping("/crear") // La ruta base para todas las operaciones de creación
public class CreacionController {

    private final PersistenceService persistenceService;

    @Autowired
    public CreacionController(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @GetMapping("/articulos") // Ruta para crear un artículo
    public List<Articulo> obtenerArticulos() {
        return persistenceService.obtenerArticulo();
    }

    @GetMapping("/clientes") // Ruta para obtener todos los clientes
    public List<Clientes> obtenerClientes() {
        return persistenceService.obtenerCliente();
    }

    
    @GetMapping("/elencos") // Ruta para obtener todos los elencos
    public List<Elenco> obtenerElencos() {
        return persistenceService.obtenerElenco();
    }

    @GetMapping("/empleados") // Ruta para obtener todos los empleados
    public List<Empleados> obtenerEmpleados() {
        return persistenceService.obtenerEmpleado();
    }


    @GetMapping("/generos") // Ruta para obtener todos los géneros
    public List<Generos> obtenerGeneros() {
        return persistenceService.obtenerGenero();
    }

    @GetMapping("/idiomas") // Ruta para obtener todos los idiomas
    public List<Idiomas> obtenerIdiomas() {
        return persistenceService.obtenerIdioma();
    }

    @GetMapping("/rentasdevoluciones") // Ruta para obtener todas las rentas/devoluciones
    public List<RentaDevolucion> obtenerRentasDevoluciones() {
        return persistenceService.obtenerRentaDevolucion();
    }

    @GetMapping("/tiposarticulos") // Ruta para obtener todos los tipos de artículos
    public List<TiposArticulos> obtenerTiposArticulos() {
        return persistenceService.obtenerTiposArticulo();
    }
}
