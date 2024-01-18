package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Articulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Titulo;
    
    private String TipoArticulo;
    
    private String Idioma;
    
    private int RentaXDias;
    
    private int DiasRenta;
    
    private int EntregaTardia;
    
    private String Estado;
    
    
}
