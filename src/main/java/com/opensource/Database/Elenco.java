package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Elenco extends TiposArticulos implements Serializable {

    public Elenco(int Id, String Descripcion, String Estado) {
        super(Id, Descripcion, Estado);
    } 

    public Elenco() {
    }
    
    
}
