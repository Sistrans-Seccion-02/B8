package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class habitacionEntity {
    private Integer numero;
    private String tipoHabitacion;
    private String plan;
    private Boolean television;
    private Boolean minibar;
    private Boolean cafetera;
    private Integer diasEstadia;

    public habitacionEntity(Integer numero, String tipoHabitacion, String plan, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia)
    {
        this.numero=numero;
        this.tipoHabitacion=tipoHabitacion;
        this.plan=plan;
        this.television=television;
        this.minibar=minibar;
        this.cafetera=cafetera;
        this.diasEstadia=diasEstadia;
    }
    public habitacionEntity()
    {;}
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    public Boolean getTelevision() {
        return television;
    }
    public void setTelevision(Boolean television) {
        this.television = television;
    }
    public Boolean getMinibar() {
        return minibar;
    }
    public void setMinibar(Boolean minibar) {
        this.minibar = minibar;
    }
    public Boolean getCafetera() {
        return cafetera;
    }
    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }
    public Integer getDiasEstadia() {
        return diasEstadia;
    }
    public void setDiasEstadia(Integer diasEstadia) {
        this.diasEstadia = diasEstadia;
    }
    
}
