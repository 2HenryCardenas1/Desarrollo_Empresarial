package com.example.kidsgo.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="SOLICITUD")
public class Solicitud implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private long idSolicitud;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_solicitud")
    private Date horaSolicitud;

    @NotNull
    @JoinColumn(name = "PERSONA_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPersona;

    @NotNull
    @JoinColumn(name = "ESTADO_SOLICITUD_id_estado_solicitud", referencedColumnName = "id_estado_solicitud")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoSolictud fkEstadoSolicitud;

    @NotNull
    @JoinColumn(name = "RUTA_id_Ruta", referencedColumnName = "id_Ruta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ruta fkRuta;

    public long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(Date horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    public EstadoSolictud getFkEstadoSolicitud() {
        return fkEstadoSolicitud;
    }

    public void setFkEstadoSolicitud(EstadoSolictud fkEstadoSolicitud) {
        this.fkEstadoSolicitud = fkEstadoSolicitud;
    }

    public Ruta getFkRuta() {
        return fkRuta;
    }

    public void setFkRuta(Ruta fkRuta) {
        this.fkRuta = fkRuta;
    }



}
