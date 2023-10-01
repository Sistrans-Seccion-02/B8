package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name="tipoHabitacion", referencedColumnName = "id")
    private TipoHabitacion tipoHabitacion;

    private Boolean television;
    private Boolean minibar;
    private Boolean cafetera;
    private Integer diasEstadia;

    public Habitacion(Integer numero, TipoHabitacion tipoHabitacion, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia)
    {
        this.numero=numero;
        this.tipoHabitacion=tipoHabitacion;
        this.television=television;
        this.minibar=minibar;
        this.cafetera=cafetera;
        this.diasEstadia=diasEstadia;
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
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
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
    public Integer getDiasEstadia() {
        return diasEstadia;
    }
    public void setDiasEstadia(Integer diasEstadia) {
        this.diasEstadia = diasEstadia;
    }
    
}
