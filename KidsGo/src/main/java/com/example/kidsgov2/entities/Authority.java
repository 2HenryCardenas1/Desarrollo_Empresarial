package com.example.kidsgov2.entities;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipousuario")
    private long idTipoUsuario;

    @NotNull
    //@Size(min = 1, max = 45)
    @Value(value = "ROLE_USER")
    @Column(name = "rolUser")
    private String rolUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario",referencedColumnName = "id_usuario")
    private Usuario usuario;

    public long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
