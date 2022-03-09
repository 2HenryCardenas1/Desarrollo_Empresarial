package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name = "PERSONA_VEHICULO")
public class PersonaVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personavehiculo")
    private long idPersonaVehiculo;

    @NotNull
    @JoinColumn(name = "VEHICULO_id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo fkVehiculo;

    @NotNull
    @JoinColumn(name = "PERSONA_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    public long getIdPersonaVehiculo() {
        return idPersonaVehiculo;
    }

    public void setIdPersonaVehiculo(long idPersonaVehiculo) {
        this.idPersonaVehiculo = idPersonaVehiculo;
    }

    public Vehiculo getFkVehiculo() {
        return fkVehiculo;
    }

    public void setFkVehiculo(Vehiculo fkVehiculo) {
        this.fkVehiculo = fkVehiculo;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }


}
