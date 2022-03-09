package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="ESTADO_SOLICITUD")
public class EstadoSolictud implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_solicitud")

    private long idEstadoSolicitud;


    @NotNull
    @Column(name = "descripcion")
    private String descripcionSolicitud;

    public long getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(long idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }
}
