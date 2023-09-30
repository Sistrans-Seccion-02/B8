package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class Reserva {
    private Long id;
    private Integer costoTotal;
    private Date fechaInicio;
    private Date fechaFin;
    private String planEstadia;

}
