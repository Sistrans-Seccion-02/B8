package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    HotelEntity findByNombre(String nombre);
    // You can add custom query methods here if needed
}