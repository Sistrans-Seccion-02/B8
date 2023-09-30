package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.InternetEntity;

@Repository
public interface InternetRepository extends JpaRepository<InternetEntity, Long> {
    InternetEntity findById(Integer id);
    // You can add custom query methods here if needed
}