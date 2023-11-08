package uniandes.edu.co.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("salones")
public class Salon extends Servicio {

    private Float costoPorHora;
    private Integer equipos;

    public Salon(Float capacidad, String nombre, Hotel hotel, Float costoPorHora, Integer equipos) {
        super(capacidad, nombre, hotel, "salon");
        this.costoPorHora = costoPorHora;
        this.equipos = equipos;
    }

    public Salon() {
        ;
    }

    public Float getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(Float costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

    public Integer getEquipos() {
        return equipos;
    }

    public void setEquipos(Integer equipos) {
        this.equipos = equipos;
    }

}
