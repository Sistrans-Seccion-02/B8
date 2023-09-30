package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;

@Entity
public class habitacionEntity {
    private Integer numero;
    private String tipoHabitacion;
    private String plan;
    private Boolean television;
    private Boolean minibar;
    private Boolean cafetera;
    private Integer diasEstadia;

}
