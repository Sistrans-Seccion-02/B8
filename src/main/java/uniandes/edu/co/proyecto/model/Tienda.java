package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tienda extends Servicio {

    private String tipo;
    private String productos;

    public Tienda(Integer id, Float capacidad, Float costoDanios, String nombre, String tipo, String productos) {
        super(id, capacidad, costoDanios, nombre);
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
