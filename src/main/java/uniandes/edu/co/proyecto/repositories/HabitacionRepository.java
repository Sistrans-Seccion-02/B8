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

    @Query(value = "SELECT * FROM habitaciones WHERE numero = :numero", nativeQuery = true)
    Habitacion darHabitacion(@Param("numero") Integer numero);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numero, tipoHabitacion, plan, television, minibar, cafetera, diasEstadia) VALUES (:numero, :tipoHabitacion, :plan, :television, :minibar, :cafetera, :diasEstadia)", nativeQuery = true)
    void insertarHabitacion(@Param("numero") Integer numero, @Param("tipoHabitacion") String tipoHabitacion, @Param("plan") String plan,  @Param("television") Boolean television, @Param("minibar") Boolean minibar,
                        @Param("cafetera") Boolean cafetera, @Param("diasEstadia") Integer diasEstadia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipoHabitacion = :tipoHabitacion, plan = :plan, television = :television, minibar = :minibar, cafetera = :cafetera, diasEstadia = :diasEstadia WHERE numero = :numero", nativeQuery = true)
    void actualizarHabitacion(@Param("numero") Integer numero, @Param("tipoHabitacion") String tipoHabitacion, @Param("plan") String plan,  @Param("television") Boolean television, @Param("minibar") Boolean minibar,
                        @Param("cafetera") Boolean cafetera, @Param("diasEstadia") Integer diasEstadia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE numero = :numero", nativeQuery = true)
    void eliminarHabitacion(@Param("numero") Integer numero);
    
}