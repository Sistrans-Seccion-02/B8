package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.habitacionEntity;

@Repository
public interface HabitacionRepository extends JpaRepository<habitacionEntity, Long> {
    // You can add custom query methods here if needed
    habitacionEntity findByNumero(Integer numero);
}