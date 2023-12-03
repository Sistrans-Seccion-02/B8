package com.example.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reservas")

public class Reserva {
    @Id
    private String id;

    @Field("costoTotal")
    private Double costoTotal;

    @Field("fecha_inicio")
    private Date fecha_inicio;

    @Field("fecha_fin")
    private Date fecha_fin;

    @Field("planes_estadia")
    private String planes_estadia;

    @DBRef
    private Usuario usuarios;

    @DBRef
    private Habitacion habitaciones;

    @DBRef
    private List<Consumo> consumos;

    public Reserva(){}

    public Reserva(Double costoTotal, Date fecha_inicio, Date fecha_fin, String planes_estadia){

        this.costoTotal = costoTotal;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.planes_estadia = planes_estadia;
    }

    // Constructor con todos los atributos de reserva y una lista de consumos
    public Reserva(Double costoTotal, Date fecha_inicio, Date fecha_fin, String planes_estadia, Usuario usuarios, Habitacion habitaciones, List<Consumo> consumos){
        
        this.costoTotal = costoTotal;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.planes_estadia = planes_estadia;
        this.usuarios = usuarios;
        this.habitaciones = habitaciones;
        this.consumos = consumos;
    }

    //setter para agregar una referencia de un consumo a las reservas que se tienen
    public void addConsumo(Consumo con){
        consumos.add(con);
    }

/*     //setter para agregar una referencia de un usuario a las reservas que se tienen
    public void addUsuario(Usuario usu){
        usuarios.add(usu);
    }

    //setter para agregar una referencia de un consumo a las reservas que se tienen
    public void addHabitacion(Habitacion hab){
        habitaciones.add(hab);
    } */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFechaInicio() {
        return fecha_inicio;
    }

    public void setFechaInicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFechaFinal() {
        return fecha_fin;
    }

    public void setFechaFinal(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPlanesEstadia() {
        return planes_estadia;
    }

    public void setPlanesEstadia(String planes_estadia) {
        this.planes_estadia = planes_estadia;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuarios;
    }

    public void setHabitaciones(Habitacion habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Habitacion getHabitaciones() {
        return habitaciones;
    }
    
    public void setConsumos(List<Consumo> consumos){
        this.consumos = consumos;
    }

    public List<Consumo> getConsumos(){
        return this.consumos;
    }

}