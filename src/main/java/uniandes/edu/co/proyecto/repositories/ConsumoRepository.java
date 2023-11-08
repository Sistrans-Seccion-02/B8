package uniandes.edu.co.proyecto.repositories;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (id, fecha, valorTotal) VALUES ( hotelandes_sequence.nextval, :fecha, :valorTotal)", nativeQuery = true)
    void insertarConsumo(@Param("fecha") Date fecha, @Param("valorTotal") Float valorTotal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET fecha = :fecha, valorTotal = :valorTotal WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id") Integer id, @Param("fecha") Date fecha, @Param("valorTotal") Float valorTotal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id);

}
