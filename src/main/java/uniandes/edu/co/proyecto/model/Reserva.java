package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private Integer costoTotal;
    private Date fechaInicio;
    private Date fechaFin;
    private String planEstadia;

    @ManyToOne
    @JoinColumn(name="numeroHabitacion", referencedColumnName = "numero")
    private Habitacion habitacion;

    @OneToOne
    @JoinColumn(name="idConsumo", referencedColumnName = "id")
    private Consumo consumo;


    public Reserva(Integer costoTotal, Date fechaInicio, Date fechaFin, String planEstadia, Habitacion habitacion, Consumo consumo) {
        this.costoTotal = costoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.planEstadia = planEstadia;
        this.habitacion = habitacion;
        this.consumo = consumo;
    }

    public Reserva() {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPlanEstadia() {
        return planEstadia;
    }

    public void setPlanEstadia(String planEstadia) {
        this.planEstadia = planEstadia;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }
    
}
