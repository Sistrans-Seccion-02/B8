package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="supermercados")
public class Supermercado extends Servicio {

    private String productos;

    public Supermercado(Float capacidad, Float costoDanios, String nombre, Hotel hotel, String productos) {
        super(capacidad, costoDanios, nombre, hotel);
        this.productos = productos;
    }

    public Supermercado() {;}

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
