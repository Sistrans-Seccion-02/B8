package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.SalonEntity;

@Repository
public interface SalonRepository extends JpaRepository<SalonEntity, Long> {
    SalonEntity findById(Integer id);
    // You can add custom query methods here if needed
}