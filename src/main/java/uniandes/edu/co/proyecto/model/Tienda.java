package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Tienda extends Servicio {
    private String tipo;
    private String productos;

}
