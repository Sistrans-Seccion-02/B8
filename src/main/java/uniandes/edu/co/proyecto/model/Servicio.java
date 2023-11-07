package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="clase")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected Float capacidad;
    protected String nombre;
    @ManyToOne
    @JoinColumn(name="idhotel", referencedColumnName = "id")
    protected Hotel hotel;
    @Column(insertable=false, updatable=false)
    protected String clase;

    public Servicio() {;}

    public Servicio(Float capacidad, String nombre, Hotel hotel, String clase) {
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.hotel = hotel;
        this.clase = clase;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}
