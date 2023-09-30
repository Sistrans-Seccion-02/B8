package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    Restaurante findById(Integer id);
    // You can add custom query methods here if needed
}