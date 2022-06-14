package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="colegio")
public class Colegio implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolegio")
    private long idColegio;

    @NotNull
    @Column(name = "nombrecolegio")
    private String nombreColegio;

    @NotNull
    @Column(name = "direccioncolegio")
    private String direccionColegio;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(long idColegio) {
        this.idColegio = idColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getDireccionColegio() {
        return direccionColegio;
    }

    public void setDireccionColegio(String direccionColegio) {
        this.direccionColegio = direccionColegio;
    }

}
