package uniandes.edu.co.proyecto.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")
public class GimnasioEntity extends ServicioEntity {

    private String maquinas;
    private String horario;
    public GimnasioEntity(Integer id, Float capacidad, Float costoDanios, String nombre, String maquinas,
            String horario) {
        super(id, capacidad, costoDanios, nombre);
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
