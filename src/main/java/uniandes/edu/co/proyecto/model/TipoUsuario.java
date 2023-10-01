package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposUsuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    public TipoUsuario(String nombre)
    {
        this.nombre=nombre;
    }

    public TipoUsuario() {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return nombre;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.nombre = tipoUsuario;
    }
    
}
