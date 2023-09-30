package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.TiendaEntity;

@Repository
public interface TiendaRepository extends JpaRepository<TiendaEntity, Long> {
    TiendaEntity findById(Integer id);
    // You can add custom query methods here if needed
}