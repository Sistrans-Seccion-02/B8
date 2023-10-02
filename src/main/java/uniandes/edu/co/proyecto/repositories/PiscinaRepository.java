package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Piscina;

@Repository
public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    @Query(value = "SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id = :id", nativeQuery = true)
    Piscina darPiscina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (id, profundidad, horario) VALUES (:id, :profundidad, :horario)", nativeQuery = true)
    void insertarPiscina(@Param("id") Integer id, @Param("profundidad") Float profundidad, @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET profundidad = :profundidad, horario = :horario WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") Integer id, @Param("profundidad") Float profundidad, @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id", nativeQuery = true)
    void eliminarPiscina(@Param("id") Integer id);
    
}