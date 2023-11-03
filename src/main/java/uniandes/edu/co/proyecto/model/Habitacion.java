package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "tipohabitacion", referencedColumnName = "id")
    private TipoHabitacion tipohabitacion;
    private Boolean television;
    private Boolean minibar;
    private Boolean cafetera;
    private Integer diasestadia;
    @ManyToOne
    @JoinColumn(name="idhotel", referencedColumnName = "id")
    private Hotel hotel;

    public Habitacion(Integer numero, TipoHabitacion tipoHabitacion, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia, Hotel hotel)
    {
        this.numero=numero;
        this.tipohabitacion=tipoHabitacion;
        this.television=television;
        this.minibar=minibar;
        this.cafetera=cafetera;
        this.diasestadia=diasEstadia;
        this.hotel=hotel;
    }

    public Habitacion()
    {;}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoHabitacion tipoHabitacion) {
        this.tipohabitacion = tipoHabitacion;
    }

    public Boolean getTelevision() {
        return television;
    }

    public void setTelevision(Boolean television) {
        this.television = television;
    }

    public Boolean getMinibar() {
        return minibar;
    }

    public void setMinibar(Boolean minibar) {
        this.minibar = minibar;
    }

    public Boolean getCafetera() {
        return cafetera;
    }

    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }

    public Integer getDiasestadia() {
        return diasestadia;
    }

    public void setDiasestadia(Integer diasEstadia) {
        this.diasestadia = diasEstadia;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
}
