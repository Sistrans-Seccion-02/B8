package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurantes")
public class Restaurante extends Servicio {

    private String estilo;
    private String carta;

    public Restaurante(Float capacidad, String nombre, Hotel hotel, String estilo, String carta) {
        super(capacidad, nombre, hotel, "restaurante");
        this.estilo = estilo;
        this.carta = carta;
    }

    public Restaurante() {;}

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    
}
