package uniandes.edu.co.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("supermercados")
public class Supermercado extends Servicio {

    private String productos;

    public Supermercado(Float capacidad, String nombre, Hotel hotel, String productos) {
        super(capacidad, nombre, hotel, "supermercado");
        this.productos = productos;
    }

    public Supermercado() {
        ;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
