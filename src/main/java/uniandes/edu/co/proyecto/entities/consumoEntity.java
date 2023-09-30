package uniandes.edu.co.proyecto.entities;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class consumoEntity {
    private Integer id;
    private Date fecha;
    private Float valorTotal;
}
