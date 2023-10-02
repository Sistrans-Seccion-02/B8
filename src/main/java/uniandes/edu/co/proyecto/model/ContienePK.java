package uniandes.edu.co.proyecto.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ContienePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idConsumo", referencedColumnName = "id")
    private Consumo idConsumo;

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    public ContienePK(Consumo idConsumo, Servicio idServicio) {
        super();
        this.idConsumo = idConsumo;
        this.idServicio = idServicio;
    }

    public Consumo getIdConsumo() {
        return idConsumo;
    }
    
    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdConsumo(Consumo idConsumo) {
        this.idConsumo = idConsumo;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }
    
}
