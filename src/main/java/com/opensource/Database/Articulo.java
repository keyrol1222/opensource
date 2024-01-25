package com.opensource.Database;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Articulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Titulo;
    
    @OneToMany
    private LinkedList<TiposArticulos> Tipos;
    
    @OneToMany
    private LinkedList<Idiomas> idiomas;
    
    private int RentaXDias;
    
    private int DiasRenta;
    
    private int EntregaTardia;
    
    private String Estado;
    
    
}
