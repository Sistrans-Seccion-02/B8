package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.SupermercadoEntity;

@Repository
public interface SupermercadoRepository extends JpaRepository<SupermercadoEntity, Long> {
    SupermercadoEntity findById(Integer id);
    // You can add custom query methods here if needed
}