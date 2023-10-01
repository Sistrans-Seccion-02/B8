package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    private Integer cedula;
    
    private String nombre;
    private String apellido;
    private String correo;
    private String tipoUsuario;
    private String password;
    private Integer numAcompañantes;
    private String areaEmpleado;

    public Usuario(Integer cedula, String nombre, String apellido, String correo, String tipoUsuario, String password, Integer numAcompañantes, String areaEmpleado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
        this.numAcompañantes = numAcompañantes;
        this.areaEmpleado = areaEmpleado;
    }

    public Usuario() {;}

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumAcompañantes() {
        return numAcompañantes;
    }

    public void setNumAcompañantes(Integer numAcompañantes) {
        this.numAcompañantes = numAcompañantes;
    }

    public String getAreaEmpleado() {
        return areaEmpleado;
    }

    public void setAreaEmpleado(String areaEmpleado) {
        this.areaEmpleado = areaEmpleado;
    }

}
