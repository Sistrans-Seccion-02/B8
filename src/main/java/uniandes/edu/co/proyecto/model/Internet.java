package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet extends Servicio {
    private Float cobroPorDia;

    public Internet(Float capacidad, Float costoDanios, String nombre, Hotel hotel, Float cobroPorDia) {
        super(capacidad, costoDanios, nombre, hotel);
        this.cobroPorDia = cobroPorDia;
    }
    
    public Float getCobroPorDia() {
        return cobroPorDia;
    }

    public void setCobroPorDia(Float cobroPorDia) {
        this.cobroPorDia = cobroPorDia;
    }


}
