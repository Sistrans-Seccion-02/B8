package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;

    @ManyToOne
    @JoinColumn(name="tipoUsuario", referencedColumnName = "id")
    private TipoUsuario tipoUsuario;

    private String password;
    private Integer numAcompañantes;
    private String areaEmpleado;

    public Usuario(Integer cedula, String nombre, String apellido, String correo, TipoUsuario tipoUsuario, String password, Integer numAcompañantes, String areaEmpleado) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
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
