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
    private Integer costototal;
    private Date fechainicio;
    private Date fechafin;
    @ManyToOne
    @JoinColumn(name="planestadia", referencedColumnName = "id")
    private PlanEstadia planestadia;

    @ManyToOne
    @JoinColumn(name="numerohabitacion", referencedColumnName = "numero")
    private Habitacion habitacion;
    
    @OneToOne
    @JoinColumn(name="idconsumo", referencedColumnName = "id")
    private Consumo consumo;

    @ManyToOne
    @JoinColumn(name="idusuario", referencedColumnName = "id")
    private Usuario usuario;

    private String estado;

    public Reserva(Integer costoTotal, Date fechaInicio, Date fechaFin, PlanEstadia planEstadia, 
                    Habitacion habitacion, Consumo consumo, Usuario usuario, String estado) {
        this.costototal = costoTotal;
        this.fechainicio = fechaInicio;
        this.fechafin = fechaFin;
        this.planestadia = planEstadia;
        this.habitacion = habitacion;
        this.consumo = consumo;
        this.usuario = usuario;
        this.estado = estado;
    }

    public Reserva() {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostototal() {
        return costototal;
    }

    public void setCostototal(Integer costoTotal) {
        this.costototal = costoTotal;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechaInicio) {
        this.fechainicio = fechaInicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechaFin) {
        this.fechafin = fechaFin;
    }

    public PlanEstadia getPlanestadia() {
        return planestadia;
    }

    public void setPlanestadia(PlanEstadia planEstadia) {
        this.planestadia = planEstadia;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
