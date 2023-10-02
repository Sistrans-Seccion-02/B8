package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE id = :id", nativeQuery = true)
    Hotel darHotel(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (id, nombre, direccion, ciudad, pais) VALUES ( hotelandes_sequence.nextval , :nombre, :direccion, :ciudad, :pais)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre, @Param("direccion") String direccion,

            @Param("ciudad") String ciudad, @Param("pais") String pais);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre = :nombre, direccion = :direccion, ciudad = :ciudad, pais = :pais WHERE id = :id", nativeQuery = true)
    void actualizarHotel(@Param("id") long id, @Param("nombre") String nombre, @Param("direccion") String direccion,
            @Param("ciudad") String ciudad, @Param("pais") String pais);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id") long id);

}