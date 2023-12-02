package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) VALUES (habitaciones_sequence.nextval, :numero, :tipohabitacion, :television, :minibar, :cafetera, :diasestadia, :idhotel)", nativeQuery = true)
    void insertarHabitacion(@Param("numero") Integer numero, @Param("tipohabitacion") Integer tipoHabitacion,
            @Param("television") Boolean television, @Param("minibar") Boolean minibar,
            @Param("cafetera") Boolean cafetera, @Param("diasestadia") Integer diasEstadia,
            @Param("idhotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET numero = :numero, tipohabitacion = :tipohabitacion, television = :television, minibar = :minibar, cafetera = :cafetera, diasestadia = :diasestadia, idhotel = :idhotel WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") long id, @Param("numero") Integer numero, @Param("tipohabitacion") Integer tipoHabitacion,
            @Param("television") Boolean television, @Param("minibar") Boolean minibar,
            @Param("cafetera") Boolean cafetera, @Param("diasestadia") Integer diasEstadia,
            @Param("idhotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") long id);
}