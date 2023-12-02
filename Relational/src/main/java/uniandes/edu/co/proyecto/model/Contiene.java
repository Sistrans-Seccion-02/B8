package uniandes.edu.co.proyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="contiene")
public class Contiene {

    @EmbeddedId
    private ContienePK pk;

    public Contiene()
    {;}

    public Contiene(Consumo idConsumo, Servicio idServicio)
    {
        this.pk = new ContienePK(idConsumo, idServicio);
    }

    public ContienePK getPk() {
        return pk;
    }

    public void setPk(ContienePK pk) {
        this.pk = pk;
    }
    
}
