INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'ADMINISTRADOR');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'EMPLEADO');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'CLIENTE');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'RECEPCIONISTA');
INSERT INTO tiposUsuario(id, nombre) VALUES (hotelandes_sequence.nextval, 'GERENTE');

SELECT id FROM tiposUsuario
WHERE nombre = 'CLIENTE';

INSERT INTO tiposUsuario(3, 'CLIENTE2');