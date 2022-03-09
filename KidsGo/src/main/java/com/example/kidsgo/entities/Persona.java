package com.example.kidsgo.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Especificamos que es una entidad
@Entity
//Nombre de la tabla
@Table(name="PERSONA")
//Implementamos el Serializable para no instanciar cada vez que necesitemos la tabla
public class Persona implements Serializable {
    //Implementamos el Serializable para no instanciar cada vez que necesitemos la tabla
    private static final long serialVersionUID =1L;

    @Id
    @NotNull
    //GeneratedValue nos indica que es nuestra PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private long idPersona;

    @NotNull
    @Column(name = "nombre")
    private String nombrePersona;

    @NotNull
    @Column(name = "apellido")
    private String apellidoPersona;

    @NotNull
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @NotNull
    @Column(name = "numero_indentificacion")
    private String numeroIdentificacion;

    @NotNull
    @Column(name = "direccion")
    private String direccion;


    @NotNull
    @Column(name = "celular")
    private String celular;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;


    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
