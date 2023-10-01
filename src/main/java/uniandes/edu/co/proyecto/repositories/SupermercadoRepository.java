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
    @Query(value = "INSERT INTO supermercados (id, capacidad, costoDanios, nombre, productos) VALUES (:id, :capacidad, :costoDanios, :nombre, :productos)", nativeQuery = true)
    void insertarSupermercado(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                            @Param("nombre") String nombre, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE supermercados SET capacidad = :capacidad, costoDanios = :costoDanios, nombre = :nombre, productos = :productos WHERE id = :id", nativeQuery = true)
    void actualizarSupermercado(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                            @Param("nombre") String nombre, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM supermercados WHERE id = :id", nativeQuery = true)
    void eliminarSupermercado(@Param("id") Integer id);
    
}