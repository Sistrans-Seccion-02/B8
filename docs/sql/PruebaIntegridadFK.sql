INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipoUsuario, password, numAcompaniantes, areaEmpleado)
VALUES (hotelandes_sequence.nextval,123,'John','Doe','johndoe@mymail.com',3,'password',2,NULL);

-- No se puede insertar porque aún no existe FK en tipoUsuarios con id=9
INSERT INTO usuarios(id, cedula, nombre, apellido, correo, tipoUsuario, password, numAcompaniantes, areaEmpleado)
VALUES (hotelandes_sequence.nextval,123,'John','Doe','johndoe@mymail.com',9,'password',2,NULL);