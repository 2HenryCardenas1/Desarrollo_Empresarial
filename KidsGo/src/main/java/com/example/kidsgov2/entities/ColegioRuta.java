package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colegio_ruta")
public class ColegioRuta implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colegio_ruta")
    private long idColegioRuta;

    @NotNull
    @JoinColumn(name = "colegio_idcolegio", referencedColumnName = "idcolegio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Colegio fkColegio;

       @NotNull
    @JoinColumn(name = "ruta_idruta", referencedColumnName = "idruta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ruta fkRuta;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdColegioRuta() {
        return idColegioRuta;
    }

    public void setIdColegioRuta(long idColegioRuta) {
        this.idColegioRuta = idColegioRuta;
    }

    public Colegio getFkColegio() {
        return fkColegio;
    }

    public void setFkColegio(Colegio fkColegio) {
        this.fkColegio = fkColegio;
    }

    public Ruta getFkRuta() {
        return fkRuta;
    }

    public void setFkRuta(Ruta fkRuta) {
        this.fkRuta = fkRuta;
    }
}
