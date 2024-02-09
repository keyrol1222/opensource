package com.opensource.Database;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empleados implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Nombre;
    
    private int Cedula;
    
    private String TandaLaboral;
    
    private int PorcientoComision;
    
    @Temporal(TemporalType.DATE)
    private Date FechaIngreso;
    
    private String Estado;

    public Empleados() {
    }

    //Constructor con todo
    public Empleados(String Nombre, int Cedula, String TandaLaboral, int PorcientoComision, Date FechaIngreso, String Estado) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.TandaLaboral = TandaLaboral;
        this.PorcientoComision = PorcientoComision;
        this.FechaIngreso = FechaIngreso;
        this.Estado = Estado;
    }

    //Constructor sin id
    public Empleados(Long Id, String Nombre, int Cedula, String TandaLaboral, int PorcientoComision, Date FechaIngreso, String Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.TandaLaboral = TandaLaboral;
        this.PorcientoComision = PorcientoComision;
        this.FechaIngreso = FechaIngreso;
        this.Estado = Estado;
    }
    
    
    
}
