package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.SpaEntity;

@Repository
public interface SpaRepository extends JpaRepository<SpaEntity, Long> {
    SpaEntity findById(Integer id);
    // You can add custom query methods here if needed
}