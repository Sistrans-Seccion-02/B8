package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.entities.LavanderiaEmboladaEntity;

@Repository
public interface LavanderiaEmboladaRepository extends JpaRepository<LavanderiaEmboladaEntity, Long> {
    LavanderiaEmboladaEntity findById(Integer id);
    // You can add custom query methods here if needed
}