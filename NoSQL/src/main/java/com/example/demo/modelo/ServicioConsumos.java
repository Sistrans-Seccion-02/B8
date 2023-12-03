package com.example.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "servicios_consumos")
public class ServicioConsumos {

    @Id
    private String id;

    // Fecha del consumo
    private Date fecha;

    // Lista de servicios embebidos en el documento principal
    private List<ServicioEmbedded> Servicios;

    public ServicioConsumos(){
        //Constructor vacio para el uso de Spring
    }

    public ServicioConsumos(Date fecha, List<ServicioEmbedded> servicios) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.fecha = fecha;
        this.Servicios = servicios;
    }
    
    //<---------- Getters and Setters ---------->
    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }   

    public List<ServicioEmbedded> getServicios(){
        return Servicios;
    }

    public void setServicios(List<ServicioEmbedded> servicios){
        this.Servicios = servicios;
    }

    public void addServicio(ServicioEmbedded servicio){
        this.Servicios.add(servicio);
    }
    
}
