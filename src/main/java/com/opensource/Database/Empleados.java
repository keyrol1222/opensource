package com.opensource.Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Empleados implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Nombre;
    
    private int Cedula;
    
    private String TandaLaboral;
    
    private int PorcientoComision;
    
    @Temporal(TemporalType.DATE)
    private Date FechaIngreso;
    
    private String Estado;
    
}
