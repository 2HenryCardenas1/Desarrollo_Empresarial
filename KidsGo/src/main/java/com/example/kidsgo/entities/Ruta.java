package com.example.kidsgo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="RUTA")
public class Ruta implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Ruta")
    private long idRuta;

    @NotNull
    @Column(name = "nombre_ruta")
    private String nombreRuta;

    @NotNull
    @JoinColumn(name = "COLEGIO_id_colegio", referencedColumnName = "id_colegio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Colegio fkColegio;

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

    public Colegio getFkColegio() {
        return fkColegio;
    }

    public void setFkColegio(Colegio fkColegio) {
        this.fkColegio = fkColegio;
    }
}
