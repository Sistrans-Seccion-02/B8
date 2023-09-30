package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class LavanderiaEmboladaEntity extends ServicioEntity {
    private String catalogo;
    private Integer numeroPrendas;
    private String tipoPrenda;

}
