package com.example.demo.modelo;

/* import java.util.Date;
import java.util.List; */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
/* import org.springframework.data.mongodb.core.mapping.DBRef; */
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "habitaciones")

public class Habitacion {
    @Id
    private String id;

    @Field("numero")
    private Integer numero;

    @DBRef
    private TipoHabitacion tipoHabitaciones;

    @Field("television")
    private Boolean television;

    @Field("minibar")
    private Boolean minibar;

    @Field("cafetera")
    private Boolean cafetera;

    @Field("diasEstadia")
    private Integer diasEstadia;

    @Field("idHotel")
    private String idHotel;

    public Habitacion(){}

    public Habitacion(Integer numero, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia, String idHotel){

        this.numero = numero;
        this.television = television;
        this.minibar = minibar;
        this.cafetera = cafetera;
        this.diasEstadia = diasEstadia;
        this.idHotel = idHotel;
    }

    // Constructor con todos los atributos de reserva y una lista de consumos
    public Habitacion(Integer numero, TipoHabitacion tipoHabitaciones, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia, String idHotel){
        
        this.numero = numero;
        this.tipoHabitaciones = tipoHabitaciones;
        this.television = television;
        this.minibar = minibar;
        this.cafetera = cafetera;
        this.diasEstadia = diasEstadia;
        this.idHotel = idHotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipoHabitaciones(TipoHabitacion tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }

    public TipoHabitacion getTipoHabitaciones() {
        return tipoHabitaciones;
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

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }
}