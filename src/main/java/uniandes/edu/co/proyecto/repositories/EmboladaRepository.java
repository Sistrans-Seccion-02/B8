package uniandes.edu.co.proyecto.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Embolada;

//public class EmboladaRepository {}

@Repository
public interface EmboladaRepository extends JpaRepository<Embolada, Long> {
    Embolada findById(Integer id);
    // You can add custom query methods here if needed
}