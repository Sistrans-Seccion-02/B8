package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
    Salon findById(Integer id);
    // You can add custom query methods here if needed
}