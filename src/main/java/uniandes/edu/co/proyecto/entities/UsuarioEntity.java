package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.OneToMany;

public class UsuarioEntity {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipoUsuario;
    private String password;
    private Integer numAcompañantes;
    private String AreaEmpleado;


    
}
