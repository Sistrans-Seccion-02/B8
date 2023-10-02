package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    @Query(value = "SELECT * FROM restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurantes WHERE id = :id", nativeQuery = true)
    Restaurante darRestaurante(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes (id, estilo, carta) VALUES ( :id, :estilo, :carta)", nativeQuery = true)
    void insertarRestaurante(@Param("id") Integer id, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET estilo = :estilo, carta = :carta WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantes WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);

}