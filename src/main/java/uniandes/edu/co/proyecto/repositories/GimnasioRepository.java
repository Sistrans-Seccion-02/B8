package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.GimnasioEntity;

@Repository
public interface GimnasioRepository extends JpaRepository<GimnasioEntity, Long> {
    // You can add custom query methods here if needed
    GimnasioEntity findById(Integer id);

}