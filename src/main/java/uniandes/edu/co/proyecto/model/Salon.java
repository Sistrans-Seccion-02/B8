package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Salon extends Servicio {
    private String tipo;
    private Float costoPorHora;
    private Integer equipos;
}
