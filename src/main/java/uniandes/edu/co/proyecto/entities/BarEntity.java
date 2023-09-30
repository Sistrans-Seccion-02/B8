package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="bares")

public class BarEntity extends ServicioEntity {

    private Integer id;
    private String estilo;
    private String carta;
    public BarEntity(Integer id, Float capacidad, Float costoDanios, String nombre, Integer id2, String estilo,
            String carta) {
        super(id, capacidad, costoDanios, nombre);
        id = id2;
        this.estilo = estilo;
        this.carta = carta;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
