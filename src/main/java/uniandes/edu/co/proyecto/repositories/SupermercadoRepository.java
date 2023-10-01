package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer> {

    @Query(value = "SELECT * FROM supermercados", nativeQuery = true)
    Collection<Supermercado> darSupermercados();

    @Query(value = "SELECT * FROM supermercados WHERE id = :id", nativeQuery = true)
    Supermercado darSupermercado(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO supermercados (id, productos) VALUES (:id, :productos)", nativeQuery = true)
    void insertarSupermercado(@Param("id") Integer id, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE supermercados SET productos = :productos WHERE id = :id", nativeQuery = true)
    void actualizarSupermercado(@Param("id") Integer id, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM supermercados WHERE id = :id", nativeQuery = true)
    void eliminarSupermercado(@Param("id") Integer id);
    
}