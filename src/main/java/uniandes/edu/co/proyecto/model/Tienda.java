package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tienda extends Servicio {

    private String tipo;
    private String productos;

    public Tienda(Float capacidad, Float costoDanios, String nombre, Hotel hotel, String tipo, String productos) {
        super(capacidad, costoDanios, nombre, hotel);
        this.tipo = tipo;
        this.productos = productos;
    }

    public Tienda() {;}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
