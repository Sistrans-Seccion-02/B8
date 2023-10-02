-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 22:38:43 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
    id     INTEGER NOT NULL,
    estilo VARCHAR2(255) NOT NULL,
    carta  VARCHAR2(255) NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id );

CREATE TABLE consumos (
    id         INTEGER NOT NULL,
    fecha      DATE NOT NULL,
    valortotal FLOAT(2) NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( id );

CREATE TABLE contiene (
    idservicio INTEGER NOT NULL,
    idconsumo  INTEGER NOT NULL
);

ALTER TABLE contiene ADD CONSTRAINT contiene_pk PRIMARY KEY ( idconsumo,
                                                              idservicio );

CREATE TABLE emboladas (
    id            INTEGER NOT NULL,
    catalogo      VARCHAR2(255) NOT NULL,
    numeroprendas INTEGER NOT NULL,
    tipoprenda    VARCHAR2(255) NOT NULL
);

ALTER TABLE emboladas ADD CONSTRAINT emboladas_pk PRIMARY KEY ( id );

CREATE TABLE gimnasios (
    id       INTEGER NOT NULL,
    maquinas VARCHAR2(255) NOT NULL,
    horario  VARCHAR2(255) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    id             INTEGER NOT NULL,
    numero         INTEGER NOT NULL,
    tipohabitacion INTEGER NOT NULL,
    television     CHAR(1) NOT NULL,
    minibar        CHAR(1) NOT NULL,
    cafetera       CHAR(1) NOT NULL,
    diasestadia    INTEGER NOT NULL,
    idhotel        INTEGER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE hoteles (
    id        INTEGER NOT NULL,
    nombre    VARCHAR2(255) NOT NULL,
    direccion VARCHAR2(255) NOT NULL,
    ciudad    VARCHAR2(255) NOT NULL,
    pais      VARCHAR2(255) NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( id );

CREATE TABLE lavanderias (
    id            INTEGER NOT NULL,
    catalogo      VARCHAR2(255) NOT NULL,
    numeroprendas INTEGER NOT NULL,
    tipoprenda    VARCHAR2(255) NOT NULL
);

ALTER TABLE lavanderias ADD CONSTRAINT servicioslavanderia_pk PRIMARY KEY ( id );

CREATE TABLE piscinas (
    id          INTEGER NOT NULL,
    profundidad FLOAT(2) NOT NULL,
    horario     VARCHAR2(255) NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id );

CREATE TABLE planesestadia (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE planesestadia ADD CONSTRAINT planesestadia_pk PRIMARY KEY ( id );

CREATE TABLE planesinternet (
    id          INTEGER NOT NULL,
    cobropordia FLOAT(2) NOT NULL
);

ALTER TABLE planesinternet ADD CONSTRAINT planesinternet_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    id               INTEGER NOT NULL,
    costototal       FLOAT(2) NOT NULL,
    fechainicio      DATE NOT NULL,
    fechafin         DATE NOT NULL,
    planesestadia    INTEGER NOT NULL,
    numerohabitacion INTEGER,
    idconsumo        INTEGER NOT NULL
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        idconsumo
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE restaurantes (
    id     INTEGER NOT NULL,
    estilo VARCHAR2(255) NOT NULL,
    carta  VARCHAR2(255) NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id );

CREATE TABLE salones (
    id           INTEGER NOT NULL,
    tipo         VARCHAR2(255) NOT NULL,
    costoporhora FLOAT(2) NOT NULL,
    equipos      INTEGER NOT NULL
);

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
    id          INTEGER NOT NULL,
    capacidad   INTEGER NOT NULL,
    costodanios FLOAT(2) NOT NULL,
    nombre      VARCHAR2(255) NOT NULL,
    idhotel     INTEGER NOT NULL,
    clase       VARCHAR2(255) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE spas (
    id       INTEGER NOT NULL,
    catalogo VARCHAR2(255) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE supermercados (
    id        INTEGER NOT NULL,
    productos VARCHAR2(255) NOT NULL
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( id );

CREATE TABLE tiendas (
    id        INTEGER NOT NULL,
    tipo      VARCHAR2(255) NOT NULL,
    productos VARCHAR2(255) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id );

CREATE TABLE tiene (
    idhotel   INTEGER NOT NULL,
    idusuario INTEGER NOT NULL
);

ALTER TABLE tiene ADD CONSTRAINT tiene_pk PRIMARY KEY ( idusuario,
                                                        idhotel );

CREATE TABLE tiposhabitacion (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE tiposhabitacion ADD CONSTRAINT tiposhabitacion_pk PRIMARY KEY ( id );

CREATE TABLE tiposusuario (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE tiposusuario ADD CONSTRAINT tiposusuario_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
    id               INTEGER NOT NULL,
    cedula           INTEGER NOT NULL,
    nombre           VARCHAR2(255) NOT NULL,
    apellido         VARCHAR2(255) NOT NULL,
    correo           VARCHAR2(255) NOT NULL,
    tipousuario      INTEGER NOT NULL,
    password         VARCHAR2(255) NOT NULL,
    numacompaniantes INTEGER,
    areaempleado     VARCHAR2(255)
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE contiene
    ADD CONSTRAINT contiene_consumos_fk FOREIGN KEY ( idconsumo )
        REFERENCES consumos ( id );

ALTER TABLE contiene
    ADD CONSTRAINT contiene_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( id );

ALTER TABLE emboladas
    ADD CONSTRAINT emboladas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitacioneshotelesfk FOREIGN KEY ( idhotel )
        REFERENCES hoteles ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitacionestiposfk FOREIGN KEY ( tipohabitacion )
        REFERENCES tiposhabitacion ( id );

ALTER TABLE lavanderias
    ADD CONSTRAINT lavanderia_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE planesinternet
    ADD CONSTRAINT planesinternet_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_consumos_fk FOREIGN KEY ( idconsumo )
        REFERENCES consumos ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_habitaciones_fk FOREIGN KEY ( numerohabitacion )
        REFERENCES habitaciones ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planesestadia_fk FOREIGN KEY ( planesestadia )
        REFERENCES planesestadia ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE salones
    ADD CONSTRAINT salones_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( idhotel )
        REFERENCES hoteles ( id );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE tiene
    ADD CONSTRAINT tiene_hoteles_fk FOREIGN KEY ( idhotel )
        REFERENCES hoteles ( id );

ALTER TABLE tiene
    ADD CONSTRAINT tiene_usuarios_fk FOREIGN KEY ( idusuario )
        REFERENCES usuarios ( id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuariostiposfk FOREIGN KEY ( tipousuario )
        REFERENCES tiposusuario ( id );

ALTER TABLE reservas
	ADD CONSTRAINT reservas_ck 
	    CHECK (fechainicio < fechafin);

CREATE OR REPLACE TRIGGER arc_fkarc_1_spas BEFORE
    INSERT OR UPDATE OF id ON spas
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'spa' ) THEN
        raise_application_error(-20223, 'FK Spas_Servicios_FK in Table Spas violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''spa'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_supermercados BEFORE
    INSERT OR UPDATE OF id ON supermercados
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'supermercado' ) THEN
        raise_application_error(-20223, 'FK Supermercados_Servicios_FK in Table Supermercados violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''supermercado'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_restaurantes BEFORE
    INSERT OR UPDATE OF id ON restaurantes
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'restaurante' ) THEN
        raise_application_error(-20223, 'FK Restaurantes_Servicios_FK in Table Restaurantes violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''restaurante'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_planesinternet BEFORE
    INSERT OR UPDATE OF id ON planesinternet
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'internet' ) THEN
        raise_application_error(-20223, 'FK PlanesInternet_Servicios_FK in Table PlanesInternet violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''internet'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_bares BEFORE
    INSERT OR UPDATE OF id ON bares
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'bar' ) THEN
        raise_application_error(-20223, 'FK Bares_Servicios_FK in Table Bares violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''bar'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_salones BEFORE
    INSERT OR UPDATE OF id ON salones
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'salon' ) THEN
        raise_application_error(-20223, 'FK Salones_Servicios_FK in Table Salones violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''salon'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_piscinas BEFORE
    INSERT OR UPDATE OF id ON piscinas
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'piscina' ) THEN
        raise_application_error(-20223, 'FK Piscinas_Servicios_FK in Table Piscinas violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''piscina'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_gimnasios BEFORE
    INSERT OR UPDATE OF id ON gimnasios
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'gimnasio' ) THEN
        raise_application_error(-20223, 'FK Gimnasios_Servicios_FK in Table Gimnasios violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''gimnasio'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_lavanderias BEFORE
    INSERT OR UPDATE OF id ON lavanderias
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'lavanderia' ) THEN
        raise_application_error(-20223, 'FK Lavanderia_Servicios_FK in Table Lavanderias violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''lavanderia'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_tiendas BEFORE
    INSERT OR UPDATE OF id ON tiendas
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'tienda' ) THEN
        raise_application_error(-20223, 'FK Tiendas_Servicios_FK in Table Tiendas violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''tienda'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_emboladas BEFORE
    INSERT OR UPDATE OF id ON emboladas
    FOR EACH ROW
DECLARE
    d VARCHAR2(255);
BEGIN
    SELECT
        a.clase
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'embolada' ) THEN
        raise_application_error(-20223, 'FK Emboladas_Servicios_FK in Table Emboladas violates Arc constraint on Table Servicios - discriminator column clase doesn''t have value ''embolada'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE SEQUENCE hotelandes_sequence;

-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            22
-- CREATE INDEX                             1
-- ALTER TABLE                             44
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          11
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          1
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
