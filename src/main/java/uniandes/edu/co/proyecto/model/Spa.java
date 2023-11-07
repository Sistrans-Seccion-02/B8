package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="spas")
public class Spa extends Servicio {

    private String catalogo;

    public Spa(Float capacidad, String nombre, Hotel hotel, String catalogo) {
        super(capacidad, nombre, hotel, "spa");
        this.catalogo = catalogo;
    }

    public Spa() {;}

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

}
