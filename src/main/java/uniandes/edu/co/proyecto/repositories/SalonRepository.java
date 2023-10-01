package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {
    
    @Query(value = "SELECT * FROM salones", nativeQuery = true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT * FROM salones WHERE id = :id", nativeQuery = true)
    Salon darSalon(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (id, tipo, costoPorHora, equipos) VALUES (:id, :tipo, :costoPorHora, :equipos)", nativeQuery = true)
    void insertarSalon(@Param("id") Integer id, @Param("tipo") String tipo, @Param("costoPorHora") Float costoPorHora, @Param("equipos") Integer equipos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET tipo = :tipo, costoPorHora = :costoPorHora, equipos = :equipos WHERE id = :id", nativeQuery = true)
    void actualizarSalon(@Param("id") Integer id, @Param("tipo") String tipo, @Param("costoPorHora") Float costoPorHora, @Param("equipos") Integer equipos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE id = :id", nativeQuery = true)
    void eliminarSalon(@Param("id") Integer id);
    
}