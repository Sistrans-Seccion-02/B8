package uniandes.edu.co.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("tiendas")
public class Tienda extends Servicio {

    private String productos;

    public Tienda(Float capacidad, Float costoDanios, String nombre, Hotel hotel, String productos) {
        super(capacidad, nombre, hotel, "tienda");

        this.productos = productos;
    }

    public Tienda() {
        ;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
