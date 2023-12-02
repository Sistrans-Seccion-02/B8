package uniandes.edu.co.proyecto.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienePK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "idHotel", referencedColumnName = "id")
    private Hotel idHotel;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario idUsuario;

    public TienePK(Hotel idHotel, Usuario idUsuario) {
        super();
        this.idHotel = idHotel;
        this.idUsuario = idUsuario;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
