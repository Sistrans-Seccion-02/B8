package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Salon extends Servicio {

    private String tipo;
    private Float costoPorHora;
    private Integer equipos;

    public Salon(Float capacidad, String nombre, Hotel hotel, String tipo, Float costoPorHora, Integer equipos) {
        super(capacidad, nombre, hotel, "salon");
        this.tipo = tipo;
        this.costoPorHora = costoPorHora;
        this.equipos = equipos;
    }

    public Salon() {;}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
