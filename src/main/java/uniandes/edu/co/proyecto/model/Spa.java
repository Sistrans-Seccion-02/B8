package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="spas")
public class Spa extends Servicio {

    private String catalogo;

    public Spa(Integer id, Float capacidad, Float costoDanios, String nombre, String catalogo) {
        super(id, capacidad, costoDanios, nombre);
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
