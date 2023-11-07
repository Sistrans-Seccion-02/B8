package uniandes.edu.co.proyecto.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consumos")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private Date fecha;
    private Float valortotal;

    public Consumo(Integer id, Date fecha, Float valorTotal) {
        this.id = id;
        this.fecha = fecha;
        this.valortotal = valorTotal;
    }
    
    public Consumo() {;}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Float getValortotal() {
        return valortotal;
    }
    public void setValortotal(Float valorTotal) {
        this.valortotal = valorTotal;
    }
    
}
