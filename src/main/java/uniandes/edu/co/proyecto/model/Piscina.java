package uniandes.edu.co.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("piscinas")
public class Piscina extends Servicio {
    private Float profundidad;
    private String horario;

    public Piscina(Float capacidad, String nombre, Hotel hotel, Float profundidad,
            String horario) {
        super(capacidad, nombre, hotel, "piscina");
        this.profundidad = profundidad;
        this.horario = horario;
    }

    public Piscina() {
        ;
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
