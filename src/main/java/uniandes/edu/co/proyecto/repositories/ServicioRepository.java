package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    Servicio findById(Integer id);
    // You can add custom query methods here if needed
}