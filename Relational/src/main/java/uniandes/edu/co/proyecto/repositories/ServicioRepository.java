package uniandes.edu.co.proyecto.repositories;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, capacidad, nombre, idHotel, clase) VALUES ( servicios_sequence.nextval, :capacidad, :nombre, :idHotel, :clase)", nativeQuery = true)
    void insertarServicio(@Param("capacidad") Float capacidad, @Param("nombre") String nombre,
            @Param("idHotel") Integer idHotel, @Param("clase") String clase);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET capacidad = :capacidad, nombre = :nombre, idHotel = :idHotel WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id, @Param("capacidad") Float capacidad,
            @Param("nombre") String nombre, @Param("idHotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT s.clase, COUNT(*) AS conteo " +
            "FROM servicios s " +
            "INNER JOIN contiene c ON s.id = c.idservicio " +
            "INNER JOIN consumos co ON c.idconsumo = co.id " +
            "WHERE co.fecha > :fechainicio AND co.fecha < :fechafinal " +
            "GROUP BY s.clase " +
            "ORDER BY conteo DESC " +
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    List<Object[]> findTopServiciosBetweenDates(@Param("fechainicio") Date fechainicio,
            @Param("fechafinal") Date fechafinal);

    @Transactional(readOnly = true)
    @Query(value = "SELECT s.* " +
            "FROM servicios s " +
            "JOIN contiene ON contiene.idservicio = s.id " +
            "JOIN consumos c ON contiene.idconsumo = c.id " +
            "JOIN reservas r ON c.id = r.idconsumo " +
            "WHERE (c.valortotal BETWEEN :rangopiso AND :rangotecho) " +
            "AND (c.fecha BETWEEN :fechainicio AND :fechafin) " +
            "AND (s.clase = :clase OR s.nombre = :nombre)", nativeQuery = true)
    List<Servicio> findServiciosByCriteria(@Param("rangopiso") BigDecimal rangopiso,
            @Param("rangotecho") BigDecimal rangotecho,
            @Param("fechainicio") Date fechainicio,
            @Param("fechafin") Date fechafin,
            @Param("clase") String clase,
            @Param("nombre") String nombre);

    @Query(value = "SELECT " +
            "s.id AS ServicioID, " +
            "TRUNC(c.fecha, 'IW') AS Semana, " +
            "COUNT(*) AS VecesSolicitado " +
            "FROM " +
            "servicios s " +
            "JOIN contiene con ON s.id = con.idservicio " +
            "JOIN consumos c ON con.idconsumo = c.id " +
            "WHERE " +
            "c.fecha >= ADD_MONTHS(SYSDATE, -12) " +
            "GROUP BY " +
            "s.id, TRUNC(c.fecha, 'IW') " +
            "HAVING " +
            "COUNT(*) < 3", nativeQuery = true)
    List<Object[]> findServicesRequestedLessThanThreeTimesPerWeek();

}