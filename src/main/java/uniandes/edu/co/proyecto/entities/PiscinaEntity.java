package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class PiscinaEntity extends ServicioEntity {
    private Float profundidad;
    private String horario;
    public PiscinaEntity(Integer id, Float capacidad, Float costoDanios, String nombre, Float profundidad,
            String horario) {
        super(id, capacidad, costoDanios, nombre);
        this.profundidad = profundidad;
        this.horario = horario;
    }
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
