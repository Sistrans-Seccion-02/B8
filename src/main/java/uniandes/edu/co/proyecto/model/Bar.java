package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bares")
public class Bar extends Servicio {

    private String estilo;
    private String carta;
    public Bar(Float capacidad, Float costoDanios, String nombre, String estilo,
            String carta) {
        super(capacidad, costoDanios, nombre);
        this.estilo = estilo;
        this.carta = carta;
    }
    
    public Bar() {;}

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
