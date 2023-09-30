package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Supermercado;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado, Long> {
    Supermercado findById(Integer id);
    // You can add custom query methods here if needed
}