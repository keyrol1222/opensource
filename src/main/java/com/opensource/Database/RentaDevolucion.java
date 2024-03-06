package com.opensource.Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
public class RentaDevolucion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
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

    public RentaDevolucion() {
    }
    
    //Constructor sin id
    public RentaDevolucion(Empleados empleado, Articulo articulo, Clientes cliente, int CantidadDias, Date FechaRenta, Date FechaDevolucion, String comentario, String Estado) {
        this.empleado = empleado;
        this.articulo = articulo;
        this.cliente = cliente;
        this.CantidadDias = CantidadDias;
        this.FechaRenta = FechaRenta;
        this.FechaDevolucion = FechaDevolucion;
        this.comentario = comentario;
        this.Estado = Estado;
    }
    
    
    //Constructor con todo
    public RentaDevolucion(Long Id, Empleados empleado, Articulo articulo, Clientes cliente, int CantidadDias, Date FechaRenta, Date FechaDevolucion, String comentario, String Estado) {
        this.Id = Id;
        this.empleado = empleado;
        this.articulo = articulo;
        this.cliente = cliente;
        this.CantidadDias = CantidadDias;
        this.FechaRenta = FechaRenta;
        this.FechaDevolucion = FechaDevolucion;
        this.comentario = comentario;
        this.Estado = Estado;
    }
    
    
}
