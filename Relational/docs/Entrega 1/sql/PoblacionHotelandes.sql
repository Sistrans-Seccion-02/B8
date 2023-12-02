-- Datos para tipos de usuarios
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'ADMINISTRADOR');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'EMPLEADO');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'CLIENTE');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'RECEPCIONISTA');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'GERENTE');

-- Datos para tipos de habitaciones
INSERT INTO tiposHabitacion(id, nombre) VALUES (hotelandes_sequence.nextval, 'Sencilla');
INSERT INTO tiposHabitacion(id, nombre) VALUES (hotelandes_sequence.nextval, 'Doble');
INSERT INTO tiposHabitacion(id, nombre) VALUES (hotelandes_sequence.nextval, 'Suite');
INSERT INTO tiposHabitacion(id, nombre) VALUES (hotelandes_sequence.nextval, 'Suite Presidencial');
INSERT INTO tiposHabitacion(id, nombre) VALUES (hotelandes_sequence.nextval, 'Familiar');

-- Datos para planes de estadia
INSERT INTO planesEstadia(id, nombre) VALUES (hotelandes_sequence.nextval, 'Larga Estadia');
INSERT INTO planesEstadia(id, nombre) VALUES (hotelandes_sequence.nextval, 'Tiempo Compartido');
INSERT INTO planesEstadia(id, nombre) VALUES (hotelandes_sequence.nextval, 'Todo Incluido');
INSERT INTO planesEstadia(id, nombre) VALUES (hotelandes_sequence.nextval, 'Promocion 1');
INSERT INTO planesEstadia(id, nombre) VALUES (hotelandes_sequence.nextval, 'Promocion 2');

-- Gerente
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 1234567890, 'Gerente', 'ApellidoGerente', 'gerente@hotel.com', 5, 'password', 0, NULL);

-- Administrador de Datos
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 9876543210, 'Admin', 'Datos', 'admin@hotel.com', 1, 'password', 0, NULL);

-- Recepcionistas
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 1111111111, 'Recepcionista1', 'ApellidoRecepcionista1', 'recepcionista1@hotel.com', 4, 'password', 0, NULL);

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 2222222222, 'Recepcionista2', 'ApellidoRecepcionista2', 'recepcionista2@hotel.com', 4, 'password', 0, NULL);

-- Empleados
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 3333333333, 'Empleado1', 'ApellidoEmpleado1', 'empleado1@hotel.com', 2, 'password', 0, 'Área1');

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 4444444444, 'Empleado2', 'ApellidoEmpleado2', 'empleado2@hotel.com', 2, 'password', 0, 'Área2');

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 5555555555, 'Empleado3', 'ApellidoEmpleado3', 'empleado3@hotel.com', 2, 'password', 0, 'Área3');

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 6666666666, 'Empleado4', 'ApellidoEmpleado4', 'empleado4@hotel.com', 2, 'password', 0, 'Área4');

-- Clientes
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 7777777777, 'Cliente1', 'ApellidoCliente1', 'cliente1@hotel.com', 3, 'password', 2, NULL);

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 8888888888, 'Cliente2', 'ApellidoCliente2', 'cliente2@hotel.com', 3, 'password', 1, NULL);

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 9999999999, 'Cliente3', 'ApellidoCliente3', 'cliente3@hotel.com', 3, 'password', 0, NULL);

INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) 
VALUES (hotelandes_sequence.nextval, 1010101010, 'Cliente4', 'ApellidoCliente4', 'cliente4@hotel.com', 3, 'password', 0, NULL);

-- Habitaciones Sencillas
INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 101, 6, 1, 1, 1, 0, 1);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 102, 6, 1, 1, 1, 0, 1);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 103, 6, 1, 1, 1, 0, 1);

-- Habitaciones Dobles
INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 201, 7, 1, 1, 1, 0, 2);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 202, 7, 1, 1, 1, 0, 2);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 203, 7, 1, 1, 1, 0, 2);

-- Habitaciones Suite
INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 301, 8, 1, 1, 1, 0, 3);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 302, 8, 1, 1, 1, 0, 3);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 303, 8, 1, 1, 1, 0, 3);

-- Habitaciones Suite Presidencial
INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 401, 9, 1, 1, 1, 0, 4);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 402, 9, 1, 1, 1, 0, 4);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 403, 9, 1, 1, 1, 0, 4);

-- Habitaciones Familiares
INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 501, 10, 1, 1, 1, 0, 5);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 502, 10, 1, 1, 1, 0, 5);

INSERT INTO habitaciones(id, numero, tipohabitacion, television, minibar, cafetera, diasestadia, idhotel) 
VALUES (hotelandes_sequence.nextval, 503, 10, 1, 1, 1, 0, 5);

-- Piscina
INSERT INTO servicios(id, capacidad, costodanios, nombre, idhotel, clase) 
VALUES (hotelandes_sequence.nextval, 50, 20.0, 'Piscina', 1, 'piscina');

-- Spa
INSERT INTO servicios(id, capacidad, costodanios, nombre, idhotel, clase) 
VALUES (hotelandes_sequence.nextval, 10, 50.0, 'Spa', 2, 'spa');

-- Bar
INSERT INTO servicios(id, capacidad, costodanios, nombre, idhotel, clase) 
VALUES (hotelandes_sequence.nextval, 30, 10.0, 'Bar', 3, 'bar');

-- Restaurante
INSERT INTO servicios(id, capacidad, costodanios, nombre, idhotel, clase) 
VALUES (hotelandes_sequence.nextval, 40, 15.0, 'Restaurante', 4, 'restaurante');

-- Supermercado
INSERT INTO servicios(id, capacidad, costodanios, nombre, idhotel, clase) 
VALUES (hotelandes_sequence.nextval, 20, 5.0, 'Supermercado', 5, 'supermercado');

-- Menú de Bares
UPDATE bares SET carta = 'Cerveza-5.0,Whisky-10.0,Coctel-8.0' WHERE id = 1;

-- Menú de Restaurantes
UPDATE restaurantes SET carta = 'Entrada-8.0,Plato Principal-15.0,Postre-6.0' WHERE id = 1;

COMMIT;