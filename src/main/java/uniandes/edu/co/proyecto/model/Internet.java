package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="planesinternet")
public class Internet extends Servicio {
    private Float cobroPorDia;

    public Internet(Float capacidad, Float costoDanios, String nombre, Hotel hotel, Float cobroPorDia) {
        super(capacidad, nombre, hotel, "internet");
        this.cobroPorDia = cobroPorDia;
    }

    public Internet() {;}
    
    public Float getCobroPorDia() {
        return cobroPorDia;
    }

    public void setCobroPorDia(Float cobroPorDia) {
        this.cobroPorDia = cobroPorDia;
    }


}
