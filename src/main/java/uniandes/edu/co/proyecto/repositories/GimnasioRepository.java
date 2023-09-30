package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Gimnasio;

@Repository
public interface GimnasioRepository extends JpaRepository<Gimnasio, Long> {
    // You can add custom query methods here if needed
    Gimnasio findById(Integer id);

}