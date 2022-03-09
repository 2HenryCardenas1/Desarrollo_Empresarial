package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="COLEGIO")
public class Colegio implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colegio")
    private long idColegio;

    @NotNull
    @Column(name = "nombre_colegio")
    private String nombreColegio;

    @NotNull
    @Column(name = "direccion_colegio")
    private String direccionColegio;

    @NotNull
    @Column(name = "telefono_colegio")
    private String telefonoColegio;

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

    public String getTelefonoColegio() {
        return telefonoColegio;
    }

    public void setTelefonoColegio(String telefonoColegio) {
        this.telefonoColegio = telefonoColegio;
    }
}
