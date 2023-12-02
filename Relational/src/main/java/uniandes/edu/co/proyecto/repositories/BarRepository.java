
package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Bar;

@Repository
public interface BarRepository extends JpaRepository<Bar, Integer> {
    // You can add custom query methods here if needed

    @Query(value = "SELECT * FROM bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE id = :id", nativeQuery = true)
    Bar darBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (id, estilo, carta) VALUES (:id, :estilo, :carta)", nativeQuery = true)
    void insertarBar(@Param("id") Integer id, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET estilo = :estilo, carta = :carta WHERE id = :id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("estilo") String estilo, @Param("carta") String carta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE id = :id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);

}