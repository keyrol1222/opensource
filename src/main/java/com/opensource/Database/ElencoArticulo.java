package com.opensource.Database;

import javax.persistence.*;


public class ElencoArticulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Articulo;
    
    private String Elenco;
    
    private String Rol;
    
    
}
