package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

    private Integer id;
    private Float capacidad;
    private Float costoDanios;
    private String nombre;

    public Servicio() {;}

    public Servicio(Integer id, Float capacidad, Float costoDanios, String nombre) {
        this.id = id;
        this.capacidad = capacidad;
        this.costoDanios = costoDanios;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public Float getCostoDanios() {
        return costoDanios;
    }

    public void setCostoDanios(Float costoDanios) {
        this.costoDanios = costoDanios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
