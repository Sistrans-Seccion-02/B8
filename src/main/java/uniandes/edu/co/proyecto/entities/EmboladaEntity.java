package uniandes.edu.co.proyecto.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="emboladas")
public class EmboladaEntity extends ServicioEntity {
    private String catalogo;
    private Integer numeroPrendas;
    private String tipoPrenda;
    public EmboladaEntity(Integer id, Float capacidad, Float costoDanios, String nombre, String catalogo,
            Integer numeroPrendas, String tipoPrenda) {
        super(id, capacidad, costoDanios, nombre);
        this.catalogo = catalogo;
        this.numeroPrendas = numeroPrendas;
        this.tipoPrenda = tipoPrenda;
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