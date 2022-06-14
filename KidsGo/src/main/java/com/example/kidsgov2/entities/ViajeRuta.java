package com.example.kidsgov2.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "viaje_ruta")
public class ViajeRuta implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajeRuta")
    private long idViajeRuta;

    @NotNull
    @JoinColumn(name = "ruta_idruta", referencedColumnName = "idruta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ruta fkRuta;

    @NotNull
    @JoinColumn(name = "viaje_idviaje", referencedColumnName = "idviaje")
    @ManyToOne(fetch = FetchType.LAZY)
    private Viaje fkViaje;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdViajeRuta() {
        return idViajeRuta;
    }

    public void setIdViajeRuta(long idViajeRuta) {
        this.idViajeRuta = idViajeRuta;
    }

    public Ruta getFkRuta() {
        return fkRuta;
    }

    public void setFkRuta(Ruta fkRuta) {
        this.fkRuta = fkRuta;
    }

    public Viaje getFkViaje() {
        return fkViaje;
    }

    public void setFkViaje(Viaje fkViaje) {
        this.fkViaje = fkViaje;
    }
}
