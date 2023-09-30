package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class PiscinaEntity extends ServicioEntity {
    private Float profundidad;
    private String horario;

}
