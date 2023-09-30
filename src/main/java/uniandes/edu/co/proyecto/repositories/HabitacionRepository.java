package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    // You can add custom query methods here if needed
    Habitacion findByNumero(Integer numero);
}