package uniandes.edu.co.proyecto.repositories;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

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
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") Integer planEstadia,
                        @Param("numeroHabitacion") Integer numeroHabitacion,
                        @Param("idConsumo") Integer idConsumo, @Param("idUsuario") Integer idUsuario,
                        @Param("estado") String estado);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas SET costoTotal = :costoTotal, fechaInicio = :fechaInicio, fechaFin = :fechaFin, planEstadia = :planEstadia, numeroHabitacion = :numeroHabitacion, idConsumo = :idConsumo WHERE id = :id", nativeQuery = true)
        void actualizarReserva(@Param("id") Integer id, @Param("costoTotal") Integer costoTotal,
                        @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") Integer planEstadia,
                        @Param("numeroHabitacion") Integer numeroHabitacion, @Param("idConsumo") Integer idConsumo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas SET costoTotal = :costoTotal, fechaInicio = :fechaInicio, fechaFin = :fechaFin, planEstadia = :planEstadia, numeroHabitacion = :numeroHabitacion, idConsumo = :idConsumo, idUsuario = :idUsuario, estado = :estado WHERE id = :id", nativeQuery = true)
        void actualizarReserva(@Param("id") Integer id, @Param("costoTotal") Integer costoTotal,
                        @Param("fechaInicio") Date fechaInicio,
                        @Param("fechaFin") Date fechaFin, @Param("planEstadia") Integer planEstadia,
                        @Param("numeroHabitacion") Integer numeroHabitacion,
                        @Param("idConsumo") Integer idConsumo, @Param("idUsuario") Integer idUsuario,
                        @Param("estado") String estado);

        @Query(value = "SELECT * FROM reservas WHERE idUsuario = (SELECT id FROM usuarios WHERE cedula = :cedula)", nativeQuery = true)
        Collection<Reserva> darReservasPorUsuario(@Param("cedula") Integer cedula);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas SET estado = 'HOSPEDADO' WHERE id = :id", nativeQuery = true)
        void checkinReserva(@Param("id") Integer id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas SET estado = 'CHECK-OUT' WHERE id = :id", nativeQuery = true)
        void checkoutReserva(@Param("id") Integer id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
        void eliminarReserva(@Param("id") Integer id);

        @Transactional(readOnly = true)
        @Query(value = "SELECT " +
                        "    r.numerohabitacion AS NumeroHabitacion, " +
                        "    SUM(c.valortotal) AS DineroRecolectado " +
                        "FROM " +
                        "    reservas r " +
                        "INNER JOIN " +
                        "    consumos c ON r.idconsumo = c.id " +
                        "WHERE " +
                        "    r.fechainicio >= ADD_MONTHS(SYSDATE, -12) " +
                        "GROUP BY " +
                        "    r.numerohabitacion " +
                        "ORDER BY NumeroHabitacion", nativeQuery = true)
        List<Object[]> findDineroRecolectadoPorHabitacion();

        @Transactional(readOnly = true)
        @Query(value = "SELECT numerohabitacion, " +
                        "SUM(fechafin - fechainicio) AS dias_ocupados, " +
                        "ROUND((SUM(fechafin - fechainicio) / 366) * 100) AS porcentaje_ocupacion " +
                        "FROM reservas " +
                        "WHERE fechainicio >= ADD_MONTHS(TRUNC(SYSDATE), -12) " +
                        "GROUP BY numerohabitacion", nativeQuery = true)
        List<Object[]> findOcupacionPorHabitacion();

        @Transactional(readOnly = true)
        @Query(value = "WITH Ocupacion AS (" +
                        "    SELECT " + "        r.fechainicio, " +
                        "        COUNT(*) AS habitaciones_ocupadas " +
                        "    FROM " +
                        "        Reservas r " +
                        "    JOIN " +
                        "        Habitaciones h ON r.numeroHabitacion = h.id " +
                        "    GROUP BY " +
                        "        r.fechainicio " +
                        ") " +
                        "SELECT " +
                        "    o.fechainicio, " +
                        "    o.habitaciones_ocupadas " +
                        "FROM " +
                        "    Ocupacion o " +
                        "ORDER BY " +
                        "    o.habitaciones_ocupadas DESC " +
                        "FETCH FIRST 5 ROWS ONLY", nativeQuery = true)
        List<Object[]> findTopOccupiedDate();

        @Query(value = "WITH Ingresos AS (" +
                        "SELECT " +
                        "fecha, " +
                        "SUM(ValorTotal) AS ingresos_totales " +
                        "FROM " +
                        "Consumos " +
                        "GROUP BY " +
                        "fecha) " +
                        "SELECT " +
                        "fecha, " +
                        "ingresos_totales " +
                        "FROM " +
                        "Ingresos " +
                        "ORDER BY " +
                        "ingresos_totales DESC " +
                        "FETCH FIRST 5 ROWS ONLY", nativeQuery = true)
        List<Object[]> findTopIngresoDia();

        @Query(value = "WITH Demanda AS (" +
                        "SELECT fechainicio, COUNT(*) AS habitaciones_ocupadas " +
                        "FROM Reservas " +
                        "JOIN Habitaciones ON Reservas.numeroHabitacion = Habitaciones.id " +
                        "GROUP BY fechainicio) " +
                        "SELECT fechainicio, habitaciones_ocupadas " +
                        "FROM Demanda " +
                        "ORDER BY habitaciones_ocupadas ASC " +
                        "FETCH FIRST 5 ROWS ONLY", nativeQuery = true)
        List<Object[]> findLeastDemandedDay();

}