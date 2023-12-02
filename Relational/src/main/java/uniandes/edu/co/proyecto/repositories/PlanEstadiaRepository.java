package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.PlanEstadia;

public interface PlanEstadiaRepository extends JpaRepository<PlanEstadia, Integer> {

    @Query(value = "SELECT * FROM planesEstadia", nativeQuery = true)
    Collection<PlanEstadia> darPlanesEstadia();

    @Query(value = "SELECT * FROM planesEstadia WHERE id = :id", nativeQuery = true)
    PlanEstadia darPlanEstadia(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesEstadia (id, nombre) VALUES ( planesestadia_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarPlanEstadia(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planesEstadia SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarPlanEstadia(@Param("id") long id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesEstadia WHERE id = :id", nativeQuery = true)
    void eliminarPlanEstadia(@Param("id") long id);
    
}
