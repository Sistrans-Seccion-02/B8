package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class TiendaEntity extends ServicioEntity {
    private String tipo;
    private String productos;

}
