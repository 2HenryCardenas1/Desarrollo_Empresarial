package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="TIPO_PERSONA")

public class TipoPersona implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_persona")
    private long idTipoPersona;


    @NotNull
    @Column(name = "nombre_tipo_persona")
    private String tipoPersona;


    public long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
