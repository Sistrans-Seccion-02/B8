package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet extends Servicio {
    private Float cobroPorDia;

    public Internet(Integer id, Float capacidad, Float costoDanios, String nombre, Float cobroPorDia) {
        super(id, capacidad, costoDanios, nombre);
        this.cobroPorDia = cobroPorDia;
    }
    
    public Float getCobroPorDia() {
        return cobroPorDia;
    }

    public void setCobroPorDia(Float cobroPorDia) {
        this.cobroPorDia = cobroPorDia;
    }


}
