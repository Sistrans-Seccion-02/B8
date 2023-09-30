package uniandes.edu.co.proyecto.model;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Entity;

@Entity
public class Usuario {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipoUsuario;
    private String password;
    private Integer numAcompañantes;
    private String AreaEmpleado;

}
