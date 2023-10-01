package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Lavanderia;

@Repository
public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {
    @Query(value = "SELECT * FROM lavanderias", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();

    @Query(value = "SELECT * FROM lavanderias WHERE id = :id", nativeQuery = true)
    Lavanderia darLavanderia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (id, catalogo, numeroPrendas, tipoPrenda) VALUES (:id, :catalogo, :numeroPrendas, :tipoPrenda)", nativeQuery = true)
    void insertarLavanderia(@Param("id") Integer id, @Param("catalogo") String catalogo, @Param("numeroPrendas") Integer numeroPrendas, @Param("tipoPrenda") String tipoPrenda);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderias SET catalogo = :catalogo, numeroPrendas = :numeroPrendas, tipoPrenda = :tipoPrenda WHERE id = :id", nativeQuery = true)
    void actualizarLavanderia(@Param("id") Integer id, @Param("catalogo") String catalogo, @Param("numeroPrendas") Integer numeroPrendas, @Param("tipoPrenda") String tipoPrenda);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavanderias WHERE id = :id", nativeQuery = true)
    void eliminarLavanderia(@Param("id") Integer id);
}