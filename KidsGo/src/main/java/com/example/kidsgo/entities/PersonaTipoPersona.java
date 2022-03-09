package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name = "PERSONA_TIPOPERSONA")

public class PersonaTipoPersona implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_persona_tipoPersona")
    private long idPersonaHasTipoPersona;

    @NotNull
    //nombre de la columna de la fk, nombre de la columna a la que hace referencia la fk
    @JoinColumn(name = "id_fk_Persona", referencedColumnName = "idpersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    @NotNull
    @JoinColumn(name = "id_fk_TipoPersona", referencedColumnName = "id_tipo_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPersona fkTipoPersona;

    public long getIdPersonaHasTipoPersona() {
        return idPersonaHasTipoPersona;
    }

    public void setIdPersonaHasTipoPersona(long idPersonaHasTipoPersona) {
        this.idPersonaHasTipoPersona = idPersonaHasTipoPersona;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    public TipoPersona getFkTipoPersona() {
        return fkTipoPersona;
    }

    public void setFkTipoPersona(TipoPersona fkTipoPersona) {
        this.fkTipoPersona = fkTipoPersona;
    }


}
