
package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Idiomas extends TiposArticulos implements Serializable {


    public Idiomas(int Id, String Descripcion, String Estado) {
        super(Id, Descripcion, Estado);
    }

    public Idiomas() {
    }
}
