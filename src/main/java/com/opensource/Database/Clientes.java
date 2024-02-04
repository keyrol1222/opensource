
package com.opensource.Database;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Nombre;
    
    private int Cedula;
    
    private int NoTargetaCR;
    
    private int LimiteCredito;
    
    private String TipoPersona;
    
    private String Estado;

    public Clientes() {
    }

    //Constructor sin id
    public Clientes(String Nombre, int Cedula, int NoTargetaCR, int LimiteCredito, String TipoPersona, String Estado) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.NoTargetaCR = NoTargetaCR;
        this.LimiteCredito = LimiteCredito;
        this.TipoPersona = TipoPersona;
        this.Estado = Estado;
    }

    //Constructor con todo
    public Clientes(Long Id, String Nombre, int Cedula, int NoTargetaCR, int LimiteCredito, String TipoPersona, String Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.NoTargetaCR = NoTargetaCR;
        this.LimiteCredito = LimiteCredito;
        this.TipoPersona = TipoPersona;
        this.Estado = Estado;
    }
    
    
    
    
}
