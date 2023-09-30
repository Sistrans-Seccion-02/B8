package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.consumoEntity;

@Repository
public interface ConsumoRepository extends JpaRepository<consumoEntity, Long> {
    consumoEntity findById(Integer id);

}
