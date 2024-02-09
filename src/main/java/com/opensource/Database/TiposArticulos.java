package com.opensource.Database;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TiposArticulos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Descripcion;
    
    private String Estado;

    //Constructor con todo
    public TiposArticulos(Long Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    //constructor sin id
    public TiposArticulos(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    public TiposArticulos() {
    }
    
    
    
}
