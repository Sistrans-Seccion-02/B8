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
    private Usuario usuario;

    @DBRef
    private Habitacion habitacion;

    @DBRef
    private List<Consumo> consumos;

    @Field("estado")
    private String estado;

    public Reserva(){}

    // Constructor con todos los atributos de reserva y una lista de consumos
    public Reserva(Double costoTotal, Date fecha_inicio, Date fecha_fin, String planes_estadia, Usuario usuario, Habitacion habitacion, List<Consumo> consumos){
        
        this.costoTotal = costoTotal;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.planes_estadia = planes_estadia;
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.consumos = consumos;
        this.estado = "RESERVADO";
    }

    //setter para agregar una referencia de un consumo a las reservas que se tienen
    public void addConsumo(Consumo con){
        consumos.add(con);
    }

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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPlanes_estadia() {
        return planes_estadia;
    }

    public void setPlanes_estadia(String planes_estadia) {
        this.planes_estadia = planes_estadia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

/*     //setter para agregar una referencia de un usuario a las reservas que se tienen
    public void addUsuario(Usuario usu){
        usuarios.add(usu);
    }

    //setter para agregar una referencia de un consumo a las reservas que se tienen
    public void addHabitacion(Habitacion hab){
        habitaciones.add(hab);
    } */



}