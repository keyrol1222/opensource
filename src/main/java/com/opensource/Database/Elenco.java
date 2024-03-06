package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Elenco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Descripcion;
    
    private String Estado;

    //Constructor con todo
    public Elenco(Long Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    //Constructor sin id
    public Elenco(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    public Elenco() {
    }
    
    
}
