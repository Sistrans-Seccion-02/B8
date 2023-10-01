package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT * FROM tiendas", nativeQuery = true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tiendas WHERE id = :id", nativeQuery = true)
    Tienda darTienda(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiendas (id, capacidad, costoDanios, nombre, tipo, productos) VALUES (:id, :capacidad, :costoDanios, :nombre, :tipo, :productos)", nativeQuery = true)
    void insertarTienda(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                        @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiendas SET capacidad = :capacidad, costoDanios = :costoDanios, nombre = :nombre, tipo = :tipo, productos = :productos WHERE id = :id", nativeQuery = true)
    void actualizarTienda(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("costoDanios") Float costoDanios,
                        @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("productos") String productos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiendas WHERE id = :id", nativeQuery = true)
    void eliminarTienda(@Param("id") Integer id);
    
}