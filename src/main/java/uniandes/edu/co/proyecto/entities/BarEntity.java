package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="bares")

public class BarEntity extends ServicioEntity {

    private String estilo;
    private String carta;
    public BarEntity(Integer id, Float capacidad, Float costoDanios, String nombre, String estilo,
            String carta) {
        super(id, capacidad, costoDanios, nombre);
        this.estilo = estilo;
        this.carta = carta;
    }
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
