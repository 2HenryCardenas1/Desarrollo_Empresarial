package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="viaje")
public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idviaje")
    private long idViaje;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @NotNull
    @Column(name = "horainicio")
    private Time horaInicio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;


    @NotNull
    @Column(name = "origenviaje")
    private String origenviaje;



    @JoinColumn(name = "persona_idpersona", referencedColumnName = "idpersona")
    //Cargo los datos que solo pido
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    @NotNull
    @JoinColumn(name = "persona_idpersonaTP", referencedColumnName = "id_Personatp")
    //Cargo los datos que solo pido
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaTipoPersona fkPersonaTP;


    @NotNull
    @Column(name = "estado")
    private boolean estado;


    public PersonaTipoPersona getFkPersonaTP() {
        return fkPersonaTP;
    }

    public void setFkPersonaTP(PersonaTipoPersona fkPersonaTP) {
        this.fkPersonaTP = fkPersonaTP;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

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

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getOrigenviaje() {
        return origenviaje;
    }

    public void setOrigenviaje(String origenviaje) {
        this.origenviaje = origenviaje;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }
}
