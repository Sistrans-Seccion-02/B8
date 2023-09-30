package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class InternetEntity extends ServicioEntity {
    private Float cobroPorDia;

    public InternetEntity(Integer id, Float capacidad, Float costoDanios, String nombre, Float cobroPorDia) {
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
