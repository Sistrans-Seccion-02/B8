package uniandes.edu.co.proyecto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")
public class Gimnasio extends Servicio {

    private String maquinas;
    private String horario;
    public Gimnasio(Float capacidad, Float costoDanios, String nombre, String maquinas,
            String horario) {
        super(capacidad, costoDanios, nombre);
        this.maquinas = maquinas;
        this.horario = horario;
    }
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
