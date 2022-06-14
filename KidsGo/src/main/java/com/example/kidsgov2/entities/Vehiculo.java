package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="vehiculo")

public class Vehiculo implements Serializable {

    private static final long  serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private long idVehiculo;


    @NotNull
    @Column(name = "marca")
    private String marcaVehiculo;

    @NotNull
    @Column(name = "modelo")
    private String modeloVehiculo;

    @NotNull
    @Column(name = "placa")
    private String placaVehiculo;

    @NotNull
    @Column(name = "color")
    private String colorVehiculo;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }
}
