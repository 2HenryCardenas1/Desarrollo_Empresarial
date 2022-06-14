package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_vehiculo")
public class PersonaVehiculo implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_vehiculo")
    private long idPersonaVehiculo;

    @NotNull
    @JoinColumn(name = "persona_idpersona", referencedColumnName = "idpersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    @NotNull
    @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo fkVehiculo;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdPersonaVehiculo() {
        return idPersonaVehiculo;
    }

    public void setIdPersonaVehiculo(long idPersonaVehiculo) {
        this.idPersonaVehiculo = idPersonaVehiculo;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    public Vehiculo getFkVehiculo() {
        return fkVehiculo;
    }

    public void setFkVehiculo(Vehiculo fkVehiculo) {
        this.fkVehiculo = fkVehiculo;
    }
}
