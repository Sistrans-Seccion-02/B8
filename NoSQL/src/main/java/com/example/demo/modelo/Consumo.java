package com.example.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "consumos")
public class Consumo {
    @Id
    private Integer id;

    @Field("fecha")
    private Date fecha;

    @Field("valorTotal")
    private Double valorTotal;

    @DBRef
    private List<Servicio> servicios;

    // Constructor vacio para el uso de Spring
    public Consumo(){}

    // Constructor solo con fecha y valor total del consumo
    public Consumo(Date fecha, Double valorTotal){
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    // Constructor con fecha y valor total del consumo y una lista de servicios
    public Consumo(Date fecha, Double valorTotal, List<Servicio> servicios){
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    //setter para agregar una referencia de servicio a los consumos que se tienen
    public void addServicio(Servicio serv){
        servicios.add(serv);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setServicios(List<Servicio> servicios){
        this.servicios = servicios;
    }

    public List<Servicio> getServicios(){
        return this.servicios;
    }


}
