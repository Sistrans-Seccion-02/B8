package uniandes.edu.co.proyecto.repositories;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (id, costoTotal, fechaInicio, fechaFin, planEstadia, numeroHabitacion, idConsumo) VALUES ( hotelandes_sequence.nextval, :costoTotal, :fechaInicio, :fechaFin, :planEstadia, :numeroHabitacion, :idConsumo)", nativeQuery = true)
    void insertarReserva(@Param("id") Integer id, @Param("costoTotal") Integer costoTotal, @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") String planEstadia, @Param("numeroHabitacion") Integer numeroHabitacion, @Param("idConsumo") Integer idConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET costoTotal = :costoTotal, fechaInicio = :fechaInicio, fechaFin = :fechaFin, planEstadia = :planEstadia, numeroHabitacion = :numeroHabitacion, idConsumo = :idConsumo WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("costoTotal") Integer costoTotal, @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") String planEstadia, @Param("numeroHabitacion") Integer numeroHabitacion, @Param("idConsumo") Integer idConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);
    
}