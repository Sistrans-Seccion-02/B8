package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class Piscina extends Servicio {
    private Float profundidad;
    private String horario;
    public Piscina(Float capacidad, Float costoDanios, String nombre, Float profundidad,
            String horario) {
        super(capacidad, costoDanios, nombre);
        this.profundidad = profundidad;
        this.horario = horario;
    }

    public Piscina() {;}

    public Float getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

}
