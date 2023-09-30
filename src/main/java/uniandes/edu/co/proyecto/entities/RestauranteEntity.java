package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class RestauranteEntity extends ServicioEntity {
    private String estilo;
    private String carta;
}
