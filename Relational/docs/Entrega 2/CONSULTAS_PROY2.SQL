-- #########RFC1################
SELECT 
    r.numerohabitacion AS NumeroHabitacion,
    SUM(c.valortotal) AS DineroRecolectado
FROM 
    reservas r
INNER JOIN 
    consumos c ON r.idconsumo = c.id
WHERE 
    r.fechainicio >= ADD_MONTHS(SYSDATE, -12)
GROUP BY 
    r.numerohabitacion
order by NumeroHabitacion;

--implementacion y va en reserva
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
-- #########RFC2################

sELECT s.clase, COUNT(*) AS conteo
FROM servicios s
INNER JOIN contiene c ON s.id = c.idservicio
INNER JOIN consumos co ON c.idconsumo = co.id
WHERE co.fecha > :fechaincio AND co.fecha < :fechafinal
GROUP BY s.clase
order by conteo desc
fETCH FIRST 20 ROWS ONLY;


-- implementacion 

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


-- #########RFC3################


SELECT numerohabitacion,
           SUM(fechafin - fechainicio) AS dias_ocupados,
           ROUND(((SUM(fechafin - fechainicio)) / 366) * 100) AS PORCENTAJE_OCUPACION
    FROM reservas
    WHERE fechainicio >= ADD_MONTHS(TRUNC(SYSDATE), -12)
    GROUP BY numerohabitacion;

-- implementacion 

@Transactional(readOnly = true)
    @Query(value = "SELECT numerohabitacion, " +
                   "SUM(fechafin - fechainicio) AS dias_ocupados, " +
                   "ROUND((SUM(fechafin - fechainicio) / 366) * 100) AS porcentaje_ocupacion " +
                   "FROM reservas " +
                   "WHERE fechainicio >= ADD_MONTHS(TRUNC(SYSDATE), -12) " +
                   "GROUP BY numerohabitacion", nativeQuery = true)
    List<Object[]> findOcupacionPorHabitacion();


-- #########RFC4################  cambiar parametros

SELECT s.*
FROM servicios s
join contiene on contiene.idservicio = s.id
JOIN consumos c ON contiene.idconsumo = c.id
JOIN reservas r ON c.id = r.idconsumo 

WHERE 
    (c.valortotal BETWEEN :rangopiso AND rangotecho:) -- Rango de precio
    AND (c.fecha BETWEEN :fechainicio AND :fechafin) -- Rango de tiempo
    AND (s.clase = :clase OR s.nombre = :nombre); -- Tipo o categoría de servicio

-- implementacion

@Transactional(readOnly = true)
    @Query(value = "SELECT s.* " +
                   "FROM servicios s " +
                   "JOIN contiene ON contiene.idservicio = s.id " +
                   "JOIN consumos c ON contiene.idconsumo = c.id " +
                   "JOIN reservas r ON c.id = r.idconsumo " +
                   "WHERE (c.valortotal BETWEEN :rangopiso AND :rangotecho) " +
                   "AND (c.fecha BETWEEN :fechainicio AND :fechafin) " +
                   "AND (s.clase = :clase OR s.nombre = :nombre)", 
          nativeQuery = true)
    List<Servicio> findServiciosByCriteria(@Param("rangopiso") BigDecimal rangopiso,
                                           @Param("rangotecho") BigDecimal rangotecho,
                                           @Param("fechainicio") Date fechainicio,
                                           @Param("fechafin") Date fechafin,
                                           @Param("clase") String clase,
                                           @Param("nombre") String nombre);

-- #########RFC5################
CREATE INDEX idx_reservas_idusuario ON reservas(idusuario);

SELECT u.nombre, SUM(c.valortotal) AS total_consumos
FROM usuarios u
INNER JOIN reservas r ON u.id = r.idusuario
INNER JOIN consumos c ON r.idconsumo = c.id
WHERE (c.fecha between :fechainicio and :fechafin)
GROUP BY u.nombre;

DROP INDEX idx_reservas_idusuario;

-- implmentacion
@Transactional(readOnly = true)
    @Query(value = "SELECT new com.yourpackage.UsuarioConsumoDTO(u.nombre, SUM(c.valortotal)) " +
                   "FROM Usuario u " +
                   "JOIN u.reservas r " +
                   "JOIN r.consumos c " +
                   "WHERE c.fecha BETWEEN :fechainicio AND :fechafin " +
                   "AND u.id = :usuarioid " +
                   "GROUP BY u.nombre")
    List<UsuarioConsumoDTO> findTotalConsumosByUsuarioAndDateRange(@Param("usuarioid") Long usuarioid,
                                                                   @Param("fechainicio") Date fechainicio,
                                                                   @Param("fechafin") Date fechafin);

-- #########RFC6################

-- A fechas mayot ocupacion
WITH Ocupacion AS (
    SELECT 
        fechainicio,
        COUNT(*) AS habitaciones_ocupadas
    FROM 
        Reservas
    JOIN 
        Habitaciones ON Reservas.numeroHabitacion = Habitaciones.id
    GROUP BY 
        fechainicio
)
SELECT 
    fechainicio,
    habitaciones_ocupadas
FROM 
    Ocupacion
ORDER BY 
    habitaciones_ocupadas DESC
FETCH FIRST 1 ROWS ONLY;

-- implementacion

@Transactional(readOnly = true)
    @Query(value = "WITH Ocupacion AS (" +
                   "    SELECT " +"        r.fechainicio, " +
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
                   "FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    List<Object[]> findTopOccupiedDate();


-- B Fechas de mayores ingresos

WITH Ingresos AS (
    SELECT 
        fecha,
        SUM(ValorTotal) AS ingresos_totales
    FROM 
        Consumos
    GROUP BY 
        fecha
)
SELECT 
    fecha,
    ingresos_totales
FROM 
    Ingresos
ORDER BY 
    ingresos_totales DESC
FETCH FIRST 1 ROWS ONLY;


-- implementacion

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
"FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
List<Object[]> findTopIngresoDia();


--C Fechas de menor demanda:

WITH Demanda AS (
    SELECT 
        fechainicio,
        COUNT(*) AS habitaciones_ocupadas
    FROM 
        Reservas
    JOIN 
        Habitaciones ON Reservas.numeroHabitacion = Habitaciones.id
    GROUP BY 
        fechainicio
)
SELECT 
    fechainicio,
    habitaciones_ocupadas
FROM 
    Demanda
ORDER BY 
    habitaciones_ocupadas ASC
FETCH FIRST 1 ROWS ONLY;

@Query(value = "WITH Demanda AS (" +
            "SELECT fechainicio, COUNT(*) AS habitaciones_ocupadas " +
            "FROM Reservas " +
            "JOIN Habitaciones ON Reservas.numeroHabitacion = Habitaciones.id " +
            "GROUP BY fechainicio) " +
            "SELECT fechainicio, habitaciones_ocupadas " +
            "FROM Demanda " +
            "ORDER BY habitaciones_ocupadas ASC " +
            "FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    Object findLeastDemandedDay();


-- #########RFC7################
WITH EstadiasCliente AS (
    SELECT 
        r.idusuario,
        SUM(r.fechafin - r.fechainicio) AS TotalDias
    FROM 
        reservas r
    WHERE 
        r.fechainicio >= ADD_MONTHS(SYSDATE, -12)
    GROUP BY 
        r.idusuario
),
ConsumosCliente AS (
    SELECT reservas.idusuario, SUM(c.valortotal) AS TotalConsumo
    FROM consumos c
    join reservas on c.id = reservas.idconsumo
    WHERE c.fecha >= ADD_MONTHS(SYSDATE, -12)
    GROUP BY  reservas.idusuario
)
SELECT u.id AS ClienteID, u.nombre, u.apellido, COALESCE(e.TotalDias, 0) AS DiasEstadia,  COALESCE(c.TotalConsumo, 0) AS ConsumoTotal
FROM usuarios u
LEFT JOIN  EstadiasCliente e ON u.id = e.idusuario
LEFT JOIN ConsumosCliente c ON u.id = c.idusuario
WHERE  COALESCE(e.TotalDias, 0) >= 14 OR COALESCE(c.TotalConsumo, 0) > 15000000
order by consumototal desc, diasestadia desc

-- implementacion

@Query(value = "WITH EstadiasCliente AS (
    SELECT 
        r.idusuario,
        SUM(r.fechafin - r.fechainicio) AS TotalDias
    FROM 
        reservas r
    WHERE 
        r.fechainicio >= ADD_MONTHS(SYSDATE, -12)
    GROUP BY 
        r.idusuario
    ),
    ConsumosCliente AS (
        SELECT reservas.idusuario, SUM(c.valortotal) AS TotalConsumo
        FROM consumos c
        join reservas on c.id = reservas.idconsumo
        WHERE c.fecha >= ADD_MONTHS(SYSDATE, -12)
        GROUP BY  reservas.idusuario
    )
    SELECT u.id AS ClienteID, u.nombre, u.apellido, COALESCE(e.TotalDias, 0) AS DiasEstadia,  COALESCE(c.TotalConsumo, 0) AS ConsumoTotal
    FROM usuarios u
    LEFT JOIN  EstadiasCliente e ON u.id = e.idusuario
    LEFT JOIN ConsumosCliente c ON u.id = c.idusuario
    WHERE  COALESCE(e.TotalDias, 0) >= 14 OR COALESCE(c.TotalConsumo, 0) > 15000000
    order by consumototal desc, diasestadia desc", nativeQuery = true)
    List<Object[]> findHighValueCustomers();

-- #########RFC8################


    SELECT 
        s.id AS ServicioID,
        TRUNC(c.fecha, 'IW') AS Semana,
        COUNT(*) AS VecesSolicitado
    FROM 
        servicios s
    JOIN contiene con ON s.id = con.idservicio
    JOIN consumos c ON con.idconsumo = c.id
    WHERE 
        c.fecha >= ADD_MONTHS(SYSDATE, -12)
    GROUP BY 
        s.id, TRUNC(c.fecha, 'IW')
    HAVING 
        COUNT(*) < 3

-- implementacion

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



-- #########RFC9################ cambiar los parametros fecha servicio y el orderby

SELECT
    usuarios.cedula AS "numeroCedula", usuarios.nombre AS "nombreCliente",
    usuarios.apellido AS "apellidoCliente", servicios.nombre AS "nombreServicio",
    consumos.fecha AS "fechaConsumo", COUNT(*) AS "numeroVecesUsado"
FROM usuarios
JOIN reservas ON reservas.idusuario = usuarios.id
join consumos on consumos.id = reservas.idconsumo
join contiene on consumos.id = contiene.idconsumo
JOIN SERVICIOS ON contiene.idservicio = servicios.id
-- Ac� ponemos el rango de fechas que necesitemos y el servicio para tener en cuenta.
WHERE consumos.fecha BETWEEN '01-01-2020' AND '31-12-2023'
AND servicios.nombre = 'restaurante'    
GROUP BY usuarios.cedula, usuarios.nombre, usuarios.apellido, servicios.nombre, consumos.fecha
HAVING COUNT(*) >= 1 -- Miramos que haya sido usado por lo menos una vez e� servicio
ORDER BY usuarios.cedula, consumos.fecha DESC, COUNT(*); 



-- #########RFC10################

SELECT
    u.cedula AS "numeroCedula",
    u.nombre AS "nombreCliente",
    u.apellido AS "apellidoCliente",
    'Nombre del Servicio' AS "servicioNoConsumido",
    NULL AS "fechaConsumo"
FROM
    usuarios u
LEFT JOIN (
    SELECT DISTINCT
        r.idusuario
    FROM
        reservas r
    INNER JOIN consumos c ON r.idconsumo = c.id
    INNER JOIN contiene co ON c.id = co.idconsumo
    INNER JOIN servicios s ON co.idservicio = s.id
    WHERE
        c.fecha BETWEEN '01-01-2020' AND '31-12-2023'
        AND s.nombre = 'restaurante'
) servicio_consumido ON u.id = servicio_consumido.idusuario
WHERE
    servicio_consumido.idusuario IS NULL
ORDER BY
    u.cedula, u.nombre, u.apellido;


-- #########RFC11################ para esta toco cambiarle que seleccionara las fechas del año porque si no devuelve todas las semans y se vuelve mas pesada


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
    s.inicio_semana;
