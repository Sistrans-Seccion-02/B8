package uniandes.edu.co.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("lavanderias")
public class Lavanderia extends Servicio {
    private String catalogo;
    private Integer numeroPrendas;
    private String tipoPrenda;

    public Lavanderia(Float capacidad, String nombre, Hotel hotel, String catalogo,
            Integer numeroPrendas, String tipoPrenda) {
        super(capacidad, nombre, hotel, "lavanderia");
        this.catalogo = catalogo;
        this.numeroPrendas = numeroPrendas;
        this.tipoPrenda = tipoPrenda;
    }

    public Lavanderia() {
        ;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public Integer getNumeroPrendas() {
        return numeroPrendas;
    }

    public void setNumeroPrendas(Integer numeroPrendas) {
        this.numeroPrendas = numeroPrendas;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

}
