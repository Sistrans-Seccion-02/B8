package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.LavanderiaEntity;

@Repository
public interface LavanderiaRepository extends JpaRepository<LavanderiaEntity, Long> {
    LavanderiaEntity findById(Integer id);
    // You can add custom query methods here if needed
}