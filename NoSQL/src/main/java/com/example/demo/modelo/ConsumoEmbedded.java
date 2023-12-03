package com.example.demo.modelo;

import java.util.Date;
import java.util.List;

/* import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
 */

public class ConsumoEmbedded {

    
    private Date fecha;
    private Double valorTotal;
    private List<Servicio> servicios;

    public ConsumoEmbedded(){}

    public ConsumoEmbedded(Date fecha, Double valorTotal, List<Servicio> servicios){

        this.fecha = fecha;
        this.valorTotal = valorTotal;
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

