package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="solicitud")
public class Solicitud implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicitud")
    private long idSolicitud;

    @NotNull
    @JoinColumn(name = "viaje_idviaje", referencedColumnName = "idviaje")
    @ManyToOne(fetch = FetchType.LAZY)
    private Viaje fkViaje;

    @NotNull
    @Column(name = "estado_solicitud")
    private Boolean estadoSolicitud;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Viaje getFkViaje() {
        return fkViaje;
    }

    public void setFkViaje(Viaje fkViaje) {
        this.fkViaje = fkViaje;
    }

    public Boolean getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Boolean estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
}
