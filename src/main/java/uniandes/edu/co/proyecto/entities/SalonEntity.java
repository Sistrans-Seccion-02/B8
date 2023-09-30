package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class SalonEntity extends ServicioEntity {
    private String tipo;
    private Float costoPorHora;
    private Integer equipos;
}
