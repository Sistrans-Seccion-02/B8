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
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, numero, tipo, television, minibar, cafetera, diasEstadia) VALUES ( hotelandes_sequence.nextval, :numero, :tipo, :television, :minibar, :cafetera, :diasEstadia)", nativeQuery = true)
    void insertarHabitacion(@Param("numero") Integer numero, @Param("tipo") Integer tipo, @Param("minibar") Boolean minibar,
                        @Param("cafetera") Boolean cafetera, @Param("diasEstadia") Integer diasEstadia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET numero = :numero, tipo = :tipo, television = :television, minibar = :minibar, cafetera = :cafetera, diasEstadia = :diasEstadia WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("numero") Integer numero, @Param("tipo") Integer tipo, @Param("minibar") Boolean minibar,
                        @Param("cafetera") Boolean cafetera, @Param("diasEstadia") Integer diasEstadia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") Integer id);
    
}