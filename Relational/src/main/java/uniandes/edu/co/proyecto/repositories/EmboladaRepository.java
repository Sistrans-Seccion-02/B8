package uniandes.edu.co.proyecto.repositories;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Embolada;

//public class EmboladaRepository {}

@Repository
public interface EmboladaRepository extends JpaRepository<Embolada, Integer> {
    @Query(value = "SELECT * FROM emboladas", nativeQuery = true)
    Collection<Embolada> darEmboladas();

    @Query(value = "SELECT * FROM emboladas WHERE id = :id", nativeQuery = true)
    Embolada darEmbolada(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO emboladas (id, catalogo, numeroPrendas, tipoPrenda) VALUES (:id, :catalogo, :numeroPrendas, :tipoPrenda)", nativeQuery = true)
    void insertarEmbolada(@Param("id") Integer id, @Param("catalogo") String catalogo, @Param("numeroPrendas") Integer numeroPrendas, @Param("tipoPrenda") String tipoPrenda);

    @Modifying
    @Transactional
    @Query(value = "UPDATE emboladas SET catalogo = :catalogo, numeroPrendas = :numeroPrendas, tipoPrenda = :tipoPrenda WHERE id = :id", nativeQuery = true)
    void actualizarEmbolada(@Param("id") Integer id, @Param("catalogo") String catalogo, @Param("numeroPrendas") Integer numeroPrendas, @Param("tipoPrenda") String tipoPrenda);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM emboladas WHERE id = :id", nativeQuery = true)
    void eliminarEmbolada(@Param("id") Integer id);

}
