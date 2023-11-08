package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Internet;

@Repository
public interface InternetRepository extends JpaRepository<Internet, Integer> {
    @Query(value = "SELECT * FROM planesInternet", nativeQuery = true)
    Collection<Internet> darPlanesInternet();

    @Query(value = "SELECT * FROM planesInternet WHERE id = :id", nativeQuery = true)
    Internet darPlanInternet(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesInternet (id, cobroPorDia) VALUES (:id, :cobroPorDia)", nativeQuery = true)
    void insertarPlanInternet(@Param("id") Integer id, @Param("cobroPorDia") Float cobroPorDia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planesInternet SET cobroPorDia = :cobroPorDia WHERE id = :id", nativeQuery = true)
    void actualizarPlanInternet(@Param("id") Integer id, @Param("cobroPorDia") Float cobroPorDia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesInternet WHERE id = :id", nativeQuery = true)
    void eliminarPlanInternet(@Param("id") Integer id);

}