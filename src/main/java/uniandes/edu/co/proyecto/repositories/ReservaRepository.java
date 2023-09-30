package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findById(Integer id);
    // You can add custom query methods here if needed
}