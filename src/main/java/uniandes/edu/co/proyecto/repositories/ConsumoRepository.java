package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
    Consumo findById(Integer id);

}
