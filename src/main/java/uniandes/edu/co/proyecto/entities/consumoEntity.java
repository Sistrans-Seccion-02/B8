package uniandes.edu.co.proyecto.entities;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class consumoEntity {
    private Integer id;
    private Date fecha;
    private Float valorTotal;
    public consumoEntity(Integer id, Date fecha, Float valorTotal) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }
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
    public Float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
