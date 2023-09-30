package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.PiscinaEntity;

@Repository
public interface PiscinaRepository extends JpaRepository<PiscinaEntity, Long> {
    PiscinaEntity findById(Integer id);
    // You can add custom query methods here if needed
}