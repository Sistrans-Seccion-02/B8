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
    @Query(value = "INSERT INTO reservas (id, costoTotal, fechaInicio, fechaFin, planEstadia, numeroHabitacion, idConsumo, idUsuario, estado) VALUES ( reservas_sequence.nextval, :costoTotal, :fechaInicio, :fechaFin, :planEstadia, :numeroHabitacion, :idConsumo, :idUsuario, :estado)", nativeQuery = true)
    void insertarReserva(@Param("costoTotal") Integer costoTotal, @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") Integer planEstadia, @Param("numeroHabitacion") Integer numeroHabitacion, 
                        @Param("idConsumo") Integer idConsumo, @Param("idUsuario") Integer idUsuario, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET costoTotal = :costoTotal, fechaInicio = :fechaInicio, fechaFin = :fechaFin, planEstadia = :planEstadia, numeroHabitacion = :numeroHabitacion, idConsumo = :idConsumo, idUsuario = :idUsuario, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("costoTotal") Integer costoTotal, @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") Integer planEstadia, @Param("numeroHabitacion") Integer numeroHabitacion, 
                        @Param("idConsumo") Integer idConsumo, @Param("idUsuario") Integer idUsuario, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);

    @Query(value = "SELECT * FROM reservas WHERE idUsuario = (SELECT id FROM usuarios WHERE correo = :correo)", nativeQuery = true)
    Reserva darReservasPorUsuario(@Param("cedula") String cedula);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET estado = :estado WHERE id = :id", nativeQuery = true)
    void checkinReserva(@Param("id") Integer id, @Param("estado") String estado);
    
}