package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="persona_tipo_persona")
public class PersonaTipoPersona implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Personatp")
    private long idPersonaTP;


    @NotNull
    @JoinColumn(name = "tipopersona_idtipopersona", referencedColumnName = "idtipopersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPersona FKtipoPersona;

    @NotNull
    @JoinColumn(name = "persona_idpersona", referencedColumnName = "idpersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona FKpersona;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdPersonaTP() {
        return idPersonaTP;
    }

    public void setIdPersonaTP(long idPersonaTP) {
        this.idPersonaTP = idPersonaTP;
    }

    public TipoPersona getFKtipoPersona() {
        return FKtipoPersona;
    }

    public void setFKtipoPersona(TipoPersona FKtipoPersona) {
        this.FKtipoPersona = FKtipoPersona;
    }

    public Persona getFKpersona() {
        return FKpersona;
    }

    public void setFKpersona(Persona FKpersona) {
        this.FKpersona = FKpersona;
    }
}
