package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="ruta")
public class Ruta implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idruta")
    private long idRuta;

    @NotNull
    @Column(name = "nombreruta")
    private String nombreRuta;

    @NotNull
    @Column(name = "tarifa")
    private float tarifa;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(long idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
