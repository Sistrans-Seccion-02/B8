package uniandes.edu.co.proyecto.entities;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class ReservaEntity {
    private Long id;
    private Integer costoTotal;
    private Date fechaInicio;
    private Date fechaFin;
    private String planEstadia;

}
