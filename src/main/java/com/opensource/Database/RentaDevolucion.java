package com.opensource.Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class RentaDevolucion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int NoRenta;
    
    @OneToOne
    private Empleados empleado;
    
    @OneToOne
    private Articulo articulo;
    
    @OneToOne
    private Clientes cliente;
    
    private int CantidadDias;
    
    @Temporal(TemporalType.DATE)
    private Date FechaRenta;
    
    @Temporal(TemporalType.DATE)
    private Date FechaDevolucion;
    
    private String comentario;
    
    private String Estado;
}
