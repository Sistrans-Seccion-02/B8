INSERT INTO planesEstadia (id, nombre) VALUES (hotelandes_sequence.nextval, 'Tiempo compartido');
SELECT id FROM planesEstadia WHERE nombre = 'Tiempo compartido';

INSERT INTO tiposHabitacion (id, nombre) VALUES (hotelandes_sequence.nextval, 'SUITE');
SELECT id FROM tiposHabitacion WHERE nombre = 'SUITE';

INSERT INTO hoteles (id, nombre, direccion, ciudad, pais) VALUES ( hotelandes_sequence.nextval , 'Hotel', 'Aca', 'Bogota', 'Colombia');
SELECT id FROM hoteles WHERE nombre = 'Hotel';

INSERT INTO habitaciones (id, numero, tipoHabitacion, television, minibar, cafetera, diasEstadia, idHotel) 
VALUES ( hotelandes_sequence.nextval, 10, 29, 1, 0, 0, 5, 30);
SELECT id FROM habitaciones WHERE diasEstadia = 5;

INSERT INTO consumos (id, fecha, valorTotal) VALUES ( hotelandes_sequence.nextval, '05-10-23', 100.0);
SELECT id FROM consumos WHERE valorTotal = 100.0;

-- No inserta correctamente porque la fecha final es antes que la fecha inicial
INSERT INTO reservas (id, costoTotal, fechaInicio, fechaFin, planEstadia, numeroHabitacion, idConsumo) 
VALUES ( hotelandes_sequence.nextval, 120.0, '05-10-23', '04-10-23', 36, 32, 35);