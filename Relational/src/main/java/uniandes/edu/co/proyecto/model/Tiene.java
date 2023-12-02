package uniandes.edu.co.proyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene")
public class Tiene {

    @EmbeddedId
    private TienePK pk;

    public Tiene()
    {;}

    public Tiene(Hotel idHotel, Usuario idUsuario)
    {
        this.pk = new TienePK(idHotel, idUsuario);
    }

    public TienePK getPk() {
        return pk;
    }

    public void setPk(TienePK pk) {
        this.pk = pk;
    }
    
}
