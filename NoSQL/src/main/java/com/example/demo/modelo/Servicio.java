package com.example.demo.modelo;

/* import java.util.Date; */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "servicios")
public class Servicio {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("capacidad")
    private Integer capacidad;

    @Field("costoDanios")
    private Double costoDanios;

    public Servicio(){}

    public Servicio(String nombre, Integer capacidad, Double costoDanios){

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costoDanios = costoDanios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
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
