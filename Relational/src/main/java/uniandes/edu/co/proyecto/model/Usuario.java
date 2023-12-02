package uniandes.edu.co.proyecto.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
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
    @JoinColumn(name = "tipousuario", referencedColumnName = "id")
    private TipoUsuario tipousuario;
    private String password;
    private Integer numacompaniantes;
    private String areaempleado;

    public Usuario() {;}

    public Usuario(Integer cedula, String nombre, String apellido, String correo, TipoUsuario tipoUsuario,
    String password, Integer numAcompañantes, String areaempleado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipousuario = tipoUsuario;
        this.password = password;
        this.numacompaniantes = numAcompañantes;
        this.areaempleado = areaempleado;
    }

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

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipoUsuario) {
        this.tipousuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumacompaniantes() {
        return numacompaniantes;
    }

    public void setNumacompaniantes(Integer numacompaniantes) {
        this.numacompaniantes = numacompaniantes;
    }

    public String getAreaempleado() {
        return areaempleado;
    }

    public void setAreaempleado(String areaempleado) {
        this.areaempleado = areaempleado;
    }

}
