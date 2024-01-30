
package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Nombre;
    
    private int Cedula;
    
    private int NoTaretaCR;
    
    private int LimiteCredito;
    
    private String TipoPersona;
    
    private String Estado;
    
}
