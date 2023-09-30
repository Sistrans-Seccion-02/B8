package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Piscina;

@Repository
public interface PiscinaRepository extends JpaRepository<Piscina, Long> {
    Piscina findById(Integer id);
    // You can add custom query methods here if needed
}