package uniandes.edu.co.proyecto.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected Float capacidad;
    protected Float costoDanios;
    protected String nombre;

    public Servicio() {;}

    public Servicio(Float capacidad, Float costoDanios, String nombre) {
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
