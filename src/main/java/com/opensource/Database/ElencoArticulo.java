package com.opensource.Database;

import javax.persistence.*;


public class ElencoArticulo {
    
    @OneToOne
    private Articulo articulo;
    
    @OneToOne
    private Elenco elenco;

    @OneToOne
    private String rol;

    public ElencoArticulo() {
    }

    //Constructor con todo
    public ElencoArticulo(Articulo articulo, Elenco elenco, String Rol) {
        this.articulo = articulo;
        this.elenco = elenco;
        this.rol = Rol;
    }
    
    
}
