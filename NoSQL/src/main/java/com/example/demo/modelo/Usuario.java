package com.example.demo.modelo;

/* import java.util.Date;
import java.util.List; */

import org.springframework.data.annotation.Id;
/* import org.springframework.data.mongodb.core.mapping.DBRef; */
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuarios")

public class Usuario {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("apellido")
    private String apellido;

    @Field("cedula")
    private Integer cedula;

    @Field("correo")
    private String correo;

    @Field("num_acompaniantes")
    private Integer num_acompaniantes;

    @Field("tipoUsuario")
    private String tipoUsuario;

    public Usuario(){}

    public Usuario(String nombre, String apellido, Integer cedula, String correo, Integer num_acompaniantes, String tipoUsuario){

        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.num_acompaniantes = num_acompaniantes;
        this.tipoUsuario = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getNumAcompaniantes() {
        return num_acompaniantes;
    }

    public void setNumAcompaniantes(Integer num_acompaniantes) {
        this.num_acompaniantes = num_acompaniantes;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}