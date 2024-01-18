package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TiposArticulos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Descripcion;
    
    private String Estado;

    public TiposArticulos(int Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public TiposArticulos() {
    }
    
    
    
}
