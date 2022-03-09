package com.example.kidsgo.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="VIAJE")


public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_VIAJE")
    private long idViaje;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_inicio")
    private Date horaInicio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;


    @NotNull
    @Column(name = "origen")
    private String origen;


    @NotNull
    @Column(name = "asientos_disponibles")
    private int asientosDisponibles;

    @NotNull
    @Column(name = "tarifa")
    private double tarifa;

    @NotNull
    @JoinColumn(name = "PERSONA_VEHICULO_id_personavehiculo", referencedColumnName = "id_personavehiculo")
    //Cargo los datos que solo pido
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaVehiculo fkPersonaVehiculo;

    @NotNull
    @JoinColumn(name = "PERSONA_VEHICULO_VEHICULO_id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo fkVehiculo;

    @NotNull
    @JoinColumn(name = "PERSONA_VEHICULO_PERSONA_idPersona",referencedColumnName = "idPersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    @NotNull
    @JoinColumn(name = "COLEGIO_id_colegio",referencedColumnName = "id_colegio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Colegio fkColegio;


    public long getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public PersonaVehiculo getFkPersonaVehiculo() {
        return fkPersonaVehiculo;
    }

    public void setFkPersonaVehiculo(PersonaVehiculo fkPersonaVehiculo) {
        this.fkPersonaVehiculo = fkPersonaVehiculo;
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

    public Colegio getFkColegio() {
        return fkColegio;
    }

    public void setFkColegio(Colegio fkColegio) {
        this.fkColegio = fkColegio;
    }




}
