package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Spa;

@Repository
public interface SpaRepository extends JpaRepository<Spa, Long> {
    Spa findById(Integer id);
    // You can add custom query methods here if needed
}