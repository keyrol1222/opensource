package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Generos extends TiposArticulos implements Serializable {

    public Generos(int Id, String Descripcion, String Estado) {
        super(Id, Descripcion, Estado);
    }

    public Generos() {
    }
    
    
      
}
