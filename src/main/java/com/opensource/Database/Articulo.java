package com.opensource.Database;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;


@Entity
@Data
public class Articulo implements Serializable {
    
    @Id
    @SequenceGenerator(name = "Articulo_sequence", sequenceName = "Articulo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Articulo_sequence")
    private Long Id;
    
    private String Titulo;
    
    @OneToMany
    private List<TiposArticulos> Tipos;
    
    @OneToMany
    private List<Idiomas> idiomas;
    
    private int RentaXDias;
    
    private int DiasRenta;
    
    private int EntregaTardia;
    
    private String Estado;

    public Articulo() {
    }
    
    //Constructor con todo
    public Articulo(Long Id, String Titulo, List<TiposArticulos> Tipos, List<Idiomas> idiomas, int RentaXDias, int DiasRenta, int EntregaTardia, String Estado) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Tipos = Tipos;
        this.idiomas = idiomas;
        this.RentaXDias = RentaXDias;
        this.DiasRenta = DiasRenta;
        this.EntregaTardia = EntregaTardia;
        this.Estado = Estado;
    }

    //constructor sin id
    public Articulo(String Titulo, List<TiposArticulos> Tipos, List<Idiomas> idiomas, int RentaXDias, int DiasRenta, int EntregaTardia, String Estado) {
        this.Titulo = Titulo;
        this.Tipos = Tipos;
        this.idiomas = idiomas;
        this.RentaXDias = RentaXDias;
        this.DiasRenta = DiasRenta;
        this.EntregaTardia = EntregaTardia;
        this.Estado = Estado;
    }
    
    
    
}
