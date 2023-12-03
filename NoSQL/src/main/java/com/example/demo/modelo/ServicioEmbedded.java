package com.example.demo.modelo;

/* import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field; */

public class ServicioEmbedded {
    
    private String nombre;
    private Integer capacidad;
    private Double costoDanios;


    public ServicioEmbedded(){}

    public ServicioEmbedded(String nombre, Integer capacidad, Double costoDanios){

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costoDanios = costoDanios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getCostoDanios() {
        return costoDanios;
    }

    public void setCostoDanios(Double costoDanios) {
        this.costoDanios = costoDanios;
    }
}
