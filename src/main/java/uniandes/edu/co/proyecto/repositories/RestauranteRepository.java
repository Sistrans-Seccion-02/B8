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
    @Query(value = "INSERT INTO restaurantes (id, capacidad, costoDanios, nombre, estilo, carta) VALUES (:id, :capacidad, :costoDanios, :nombre, :estilo, :carta)", nativeQuery = true)
    void insertarRestaurante(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                            @Param("nombre") String nombre, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET capacidad = :capacidad, costoDanios = :costoDanios, nombre = :nombre, estilo = :estilo, carta = :carta WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                            @Param("nombre") String nombre, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantes WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);

}