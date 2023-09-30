
package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Bar;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {
    // You can add custom query methods here if needed
}
