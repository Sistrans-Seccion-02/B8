package uniandes.edu.co.proyecto.repositories;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

        @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
        Collection<Usuario> darUsuarios();

        @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
        Usuario darUsuario(@Param("id") long id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO usuarios (id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) VALUES (hotelandes_sequence.nextval, :cedula, :nombre, :apellido, :correo, :tipousuario, :password, :numacompaniantes, :areaempleado)", nativeQuery = true)
        void insertarUsuario(@Param("cedula") Integer cedula, @Param("nombre") String nombre,
                        @Param("apellido") String apellido,
                        @Param("correo") String correo, @Param("tipousuario") Integer tipoUsuario,
                        @Param("password") String password,
                        @Param("numacompaniantes") Integer numAcompaniantes,
                        @Param("areaempleado") String areaEmpleado);

        @Modifying
        @Transactional
        @Query(value = "UPDATE usuarios SET cedula = :cedula, nombre = :nombre, apellido = :apellido, correo = :correo, tipousuario = :tipousuario, password = :password, numacompaniantes = :numacompaniantes, areaempleado = :areaempleado WHERE id = :id", nativeQuery = true)
        void actualizarUsuario(@Param("id") long id, @Param("cedula") Integer cedula, @Param("nombre") String nombre,
                        @Param("apellido") String apellido,
                        @Param("correo") String correo, @Param("tipousuario") Integer tipoUsuario,
                        @Param("password") String password,
                        @Param("numacompaniantes") Integer numAcompaniantes,
                        @Param("areaempleado") String areaEmpleado);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
        void eliminarUsuario(@Param("id") long id);

        @Query(value = "SELECT * FROM usuarios \r\n" + //
                        "WHERE id = (SELECT id FROM tiposUsuario WHERE nombre = :rol)", nativeQuery = true)
        void consultarUsuariosPorRol(@Param("rol") String rol);

        @Query(value = "SELECT * FROM usuarios WHERE correo = :correo", nativeQuery = true)
        Usuario darUsuarioPorCorreo(@Param("correo") String correo);

        @Transactional(readOnly = true)
        @Query(value = "SELECT new com.yourpackage.UsuarioConsumoDTO(u.nombre, SUM(c.valortotal)) " +
                        "FROM Usuario u " +
                        "JOIN u.reservas r " +
                        "JOIN r.consumos c " +
                        "WHERE c.fecha BETWEEN :fechainicio AND :fechafin " +
                        "AND u.id = :usuarioid " +
                        "GROUP BY u.nombre")
        List<Usuario> findTotalConsumosByUsuarioAndDateRange(@Param("usuarioid") Long usuarioid,
                        @Param("fechainicio") Date fechainicio,
                        @Param("fechafin") Date fechafin);

        @Query(value = "WITH EstadiasCliente AS (SELECT r.idusuario,SUM(r.fechafin - r.fechainicio) AS TotalDias" +
                        "FROM reservas r" +
                        "WHERE   r.fechainicio >= ADD_MONTHS(SYSDATE, -12)" +
                        "GROUP BY r.idusuario)," +
                        "ConsumosCliente AS (SELECT reservas.idusuario, SUM(c.valortotal) AS TotalConsumo FROM consumos c join reservas on c.id = reservas.idconsumo"
                        +
                        "WHERE c.fecha >= ADD_MONTHS(SYSDATE, -12) GROUP BY  reservas.idusuario)"
                        + """
                                        SELECT u.id AS ClienteID, u.nombre, u.apellido, COALESCE(e.TotalDias, 0) AS DiasEstadia,  COALESCE(c.TotalConsumo, 0) AS ConsumoTotal
                                        FROM usuarios u
                                        LEFT JOIN  EstadiasCliente e ON u.id = e.idusuario
                                        LEFT JOIN ConsumosCliente c ON u.id = c.idusuario
                                        WHERE  COALESCE(e.TotalDias, 0) >= 14 OR COALESCE(c.TotalConsumo, 0) > 15000000
                                        order by consumototal desc, diasestadia desc""", nativeQuery = true)
        List<Object[]> findHighValueCustomers();

        @Query(value = "SELECT " +
                        "u.cedula AS numeroCedula, u.nombre AS nombreCliente, " +
                        "u.apellido AS apellidoCliente, s.nombre AS nombreServicio, " +
                        "c.fecha AS fechaConsumo, COUNT(*) AS numeroVecesUsado " +
                        "FROM usuarios u " +
                        "JOIN reservas r ON r.idusuario = u.id " +
                        "JOIN consumos c ON c.id = r.idconsumo " +
                        "JOIN contiene ON c.id = contiene.idconsumo " +
                        "JOIN servicios s ON contiene.idservicio = s.id " +
                        "WHERE c.fecha BETWEEN :fechainicio AND :fechafin " +
                        "AND s.nombre = :nombreservicio " +
                        "GROUP BY u.cedula, u.nombre, u.apellido, s.nombre, c.fecha " +
                        "HAVING COUNT(*) >= 1 " +
                        "ORDER BY u.cedula, c.fecha DESC, COUNT(*)", nativeQuery = true)
        List<Object[]> consultarConsumoNative(@Param("fechainicio") Date fechainicio,
                        @Param("fechafin") Date fechafin,
                        @Param("nombreservicio") String nombreservicio);

        @Query(value = "SELECT " +
                        "u.cedula AS numeroCedula, " +
                        "u.nombre AS nombreCliente, " +
                        "u.apellido AS apellidoCliente, " +
                        "'Nombre del Servicio' AS servicioNoConsumido, " +
                        "NULL AS fechaConsumo " +
                        "FROM usuarios u " +
                        "LEFT JOIN (" +
                        "    SELECT DISTINCT r.idusuario " +
                        "    FROM reservas r " +
                        "    INNER JOIN consumos c ON r.idconsumo = c.id " +
                        "    INNER JOIN contiene co ON c.id = co.idconsumo " +
                        "    INNER JOIN servicios s ON co.idservicio = s.id " +
                        "    WHERE c.fecha BETWEEN :fechainicio AND :fechafin " +
                        "    AND s.nombre = :servicionombre " +
                        ") servicio_consumido ON u.id = servicio_consumido.idusuario " +
                        "WHERE servicio_consumido.idusuario IS NULL " +
                        "ORDER BY u.cedula, u.nombre, u.apellido", nativeQuery = true)
        List<Object[]> consultarUsuariosSinConsumoNative(@Param("fechainicio") Date fechainicio,
                        @Param("fechafin") Date fechafin,
                        @Param("servicionombre") String servicionombre);

        @Query(value = """
                            WITH Semana AS (
                            SELECT
                                TRUNC(fecha, 'IW') AS inicio_semana,
                                TRUNC(fecha, 'IW') + 6 AS fin_semana
                            FROM
                                consumos
                            WHERE
                                fecha BETWEEN TO_DATE('2022-01-01', 'YYYY-MM-DD') AND TO_DATE('2022-12-31', 'YYYY-MM-DD')
                            GROUP BY
                                TRUNC(fecha, 'IW')
                        ),
                            ServicioConsumo AS (
                                SELECT
                                    inicio_semana,
                                    s.clase AS clase_servicio,
                                    COUNT(*) AS cantidad,
                                    RANK() OVER (PARTITION BY inicio_semana ORDER BY COUNT(*) DESC) AS rank_mas_consumido,
                                    RANK() OVER (PARTITION BY inicio_semana ORDER BY COUNT(*)) AS rank_menos_consumido
                                FROM
                                    Semana
                                JOIN
                                    consumos c ON c.fecha BETWEEN inicio_semana AND fin_semana
                                JOIN
                                    contiene con ON c.id = con.idconsumo
                                JOIN
                                    servicios s ON con.idservicio = s.id
                                GROUP BY
                                    inicio_semana,
                                    s.clase
                            ),
                            HabitacionSolicitud AS (
                                SELECT
                                    inicio_semana,
                                    r.numeroHabitacion AS numero_habitacion,
                                    COUNT(*) AS cantidad,
                                    RANK() OVER (PARTITION BY inicio_semana ORDER BY COUNT(*) DESC) AS rank_mas_solicitada,
                                    RANK() OVER (PARTITION BY inicio_semana ORDER BY COUNT(*)) AS rank_menos_solicitada
                                FROM
                                    Semana
                                JOIN
                                    reservas r ON r.fechainicio BETWEEN inicio_semana AND fin_semana
                                GROUP BY
                                    inicio_semana,
                                    r.numeroHabitacion
                            ),
                            MasConsumido AS (
                                SELECT inicio_semana, clase_servicio
                                FROM ServicioConsumo
                                WHERE rank_mas_consumido = 1
                            ),
                            MenosConsumido AS (
                                SELECT inicio_semana, clase_servicio
                                FROM ServicioConsumo
                                WHERE rank_menos_consumido = 1
                                AND inicio_semana NOT IN (SELECT inicio_semana FROM MasConsumido)
                            )
                            SELECT
                                s.inicio_semana,
                                s.fin_semana,
                                (SELECT clase_servicio FROM MasConsumido WHERE inicio_semana = s.inicio_semana AND ROWNUM = 1) AS servicio_mas_consumido,
                                (SELECT clase_servicio FROM MenosConsumido WHERE inicio_semana = s.inicio_semana AND ROWNUM = 1) AS servicio_menos_consumido,
                                (SELECT numero_habitacion FROM HabitacionSolicitud WHERE inicio_semana = s.inicio_semana AND rank_mas_solicitada = 1 AND ROWNUM = 1) AS habitacion_mas_solicitada,
                                (SELECT numero_habitacion FROM HabitacionSolicitud WHERE inicio_semana = s.inicio_semana AND rank_menos_solicitada = 1 AND ROWNUM = 1) AS habitacion_menos_solicitada
                            FROM
                                Semana s
                            GROUP BY
                                s.inicio_semana,
                                s.fin_semana
                            ORDER BY
                                s.inicio_semana; """, nativeQuery = true)
        List<Object[]> obtenerReporteSemanal();
}
