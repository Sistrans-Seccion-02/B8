package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="supermercados")
public class Supermercado extends Servicio {

    private String productos;

    public Supermercado(Integer id, Float capacidad, Float costoDanios, String nombre, String productos) {
        super(id, capacidad, costoDanios, nombre);
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
