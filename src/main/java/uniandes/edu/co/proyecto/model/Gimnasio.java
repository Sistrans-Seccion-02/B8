package uniandes.edu.co.proyecto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")
public class Gimnasio extends Servicio {

    private String maquinas;
    private String horario;
    public Gimnasio(Float capacidad, String nombre, Hotel hotel, String maquinas,
            String horario) {
        super(capacidad, nombre, hotel, "gimnasio");
        this.maquinas = maquinas;
        this.horario = horario;
    }

    public Gimnasio() {;}

    public String getMaquinas() {
        return maquinas;
    }
    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }


}
