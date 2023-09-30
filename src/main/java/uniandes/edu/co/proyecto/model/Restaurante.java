package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Restaurante extends Servicio {
    private String estilo;
    private String carta;
}
