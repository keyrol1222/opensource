package com.opensource.Database;

import javax.persistence.*;


public class ElencoArticulo {
    
    @OneToOne
    private Articulo articulo;
    
    @OneToOne
    private Elenco elenco;
    
    private String Rol;

    public ElencoArticulo() {
    }

    //Constructor con todo
    public ElencoArticulo(Articulo articulo, Elenco elenco, String Rol) {
        this.articulo = articulo;
        this.elenco = elenco;
        this.Rol = Rol;
    }
    
    
}
