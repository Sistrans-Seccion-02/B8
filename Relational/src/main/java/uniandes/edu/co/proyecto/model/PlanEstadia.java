package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planesestadia")
public class PlanEstadia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;

    public PlanEstadia(String nombre)
    {
        this.nombre=nombre;
    }

    public PlanEstadia() {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String planEstadia) {
        this.nombre = planEstadia;
    }
    
}
