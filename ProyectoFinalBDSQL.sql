/*
 *Proyecto Final: Bases de datos
 *Integrantes:
 *	-Juan David Suaza Cruz 1427841
 *	-Juan Jose Salazar Salcedo 1428096
 *	-Edgar Mauricio Ceron Florez
 *	-Alejandro Martinez Guzman
*/

DROP TABLE if exists cargos CASCADE;
DROP TABLE if exists empleados CASCADE;
DROP TABLE if exists estaciones CASCADE;
DROP TABLE if exists rutas CASCADE;
DROP TABLE if exists estaciones_en_ruta CASCADE;
DROP TABLE if exists tipo_bus CASCADE;
DROP TABLE if exists buses CASCADE;
DROP TABLE if exists pasajeros CASCADE;
DROP TABLE if exists tarjetas CASCADE;
DROP TABLE if exists tarjeta_personalizada CASCADE;
DROP TABLE if exists solicitudes CASCADE;
DROP TABLE if exists solicitudes_presentadas CASCADE;
DROP TABLE if exists conduce CASCADE;
DROP TABLE if exists rutas_asignadas CASCADE;
DROP TABLE if exists venta_tarjetas CASCADE;
DROP TABLE if exists bus_abordado CASCADE;
DROP TABLE if exists recargas CASCADE;

CREATE TABLE cargos(
	id_cargo SERIAL PRIMARY KEY,
	nombre_cargo VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE empleados(
	cedula_empleado CHAR(10) PRIMARY KEY,
	nombre_empleado VARCHAR(50) NOT NULL,
	password VARCHAR(20) NOT NULL,
	id_cargo SERIAL NOT NULL);

CREATE TABLE estaciones(
	id_estacion SERIAL PRIMARY KEY,
	nombre_estacion VARCHAR(50) NOT NULL UNIQUE,
	ubicacion_estacion VARCHAR(50) NOT NULL,
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado));

CREATE TABLE rutas(
	id_ruta SERIAL PRIMARY KEY,
	nombre_ruta VARCHAR(30) UNIQUE,
	descripcion_ruta VARCHAR(100));

CREATE TABLE estaciones_en_ruta(
	id_ruta INTEGER REFERENCES rutas(id_ruta),
	id_estacion INTEGER REFERENCES estaciones(id_estacion),
	CONSTRAINT pk_estaciones_en_ruta PRIMARY KEY(id_ruta, id_estacion));

CREATE TABLE tipo_bus(
	id_tipo_bus SERIAL PRIMARY KEY,
	nombre_tipo VARCHAR(20) NOT NULL);

CREATE TABLE buses(
	placa_bus CHAR(6) PRIMARY KEY,
	id_tipo_bus INTEGER REFERENCES tipo_bus(id_tipo_bus));

CREATE TABLE pasajeros(
	cedula_pasajero CHAR(10) PRIMARY KEY,
	nombre_pasajero VARCHAR(50) NOT NULL);

CREATE TABLE tarjetas(
	pin_tarjeta SERIAL PRIMARY KEY,
	numero_pasajes INT DEFAULT 0,
	estado_tarjeta BOOLEAN DEFAULT TRUE);

CREATE TABLE tarjeta_personalizada(
	pin_tarjeta INTEGER REFERENCES tarjetas(pin_tarjeta),
	numero_avances INT DEFAULT 0,
	cedula_pasajero CHAR(10) REFERENCES pasajeros(cedula_pasajero),
	id_estacion INTEGER REFERENCES estaciones(id_estacion));

CREATE TABLE solicitudes(
	tiquete SERIAL PRIMARY KEY,
	respuesta_solicitud VARCHAR(250),
	estado_solicitud BOOLEAN DEFAULT FALSE,
	motivo_solicitud VARCHAR(50) NOT NULL,
	descripcion_solicitud VARCHAR(250) NOT NULL,
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado));

CREATE TABLE solicitudes_presentadas(
	cedula_pasajero CHAR(10) REFERENCES pasajeros(cedula_pasajero),
	id_estacion INTEGER REFERENCES estaciones(id_estacion),
	tiquete INTEGER REFERENCES solicitudes(tiquete),
	fecha_solicitud DATE NOT NULL,
	CONSTRAINT pk_solicitudes_presentadas PRIMARY KEY(cedula_pasajero, id_estacion, tiquete));

CREATE TABLE conduce(
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado),
	placa_bus CHAR(6) REFERENCES buses(placa_bus),
	turno_inicio INTEGER NOT NULL,
	turno_fin INTEGER NOT NULL,
	fecha DATE NOT NULL,
	CONSTRAINT pk_conduce PRIMARY KEY(cedula_empleado, placa_bus, turno_inicio, turno_fin, fecha));

CREATE TABLE rutas_asignadas(
	placa_bus CHAR(6) REFERENCES buses(placa_bus),
	id_ruta INTEGER REFERENCES rutas(id_ruta),
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado),
	turno_inicio INTEGER NOT NULL,
	turno_fin INTEGER NOT NULL,
	fecha DATE NOT NULL,
	CONSTRAINT pk_rutas_asignadas PRIMARY KEY(placa_bus, id_ruta, cedula_empleado, turno_inicio, turno_fin, fecha));

CREATE TABLE venta_tarjetas(
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado),
	pin_tarjeta INTEGER REFERENCES tarjetas(pin_tarjeta),
	fecha_venta DATE NOT NULL,
	id_estacion INTEGER REFERENCES estaciones(id_estacion),
	CONSTRAINT pk_venta_tarjetas PRIMARY KEY(cedula_empleado, pin_tarjeta, fecha_venta));

CREATE TABLE bus_abordado(
	pin_tarjeta INTEGER REFERENCES tarjetas(pin_tarjeta),
	id_ruta INTEGER REFERENCES rutas(id_ruta),
	fecha_abordaje TIMESTAMP NOT NULL,
	CONSTRAINT pk_abordaje PRIMARY KEY(pin_tarjeta, id_ruta, fecha_abordaje));
	
CREATE TABLE recargas(
	pin_tarjeta INTEGER REFERENCES tarjetas(pin_tarjeta),
	cedula_empleado CHAR(10) REFERENCES empleados(cedula_empleado),
	cantidad_recargas INTEGER NOT NULL,
	fecha_recarga TIMESTAMP WITHOUT TIME ZONE,
	CONSTRAINT pk_recargas PRIMARY KEY(pin_tarjeta, cedula_empleado, fecha_recarga)
	);

INSERT INTO cargos VALUES(1, 'Conductor');
INSERT INTO cargos VALUES(2, 'Director operativo');
INSERT INTO cargos VALUES(3, 'Auxiliar de servicio al cliente');
INSERT INTO cargos VALUES(4, 'Vendedor');
INSERT INTO cargos VALUES(5, 'Director de estacion');
INSERT INTO cargos VALUES(6, 'Gerente general');

INSERT INTO empleados VALUES('0101010101', 'Obi Wan Kenobe', '12345', 6);
INSERT INTO empleados VALUES('1111111111','Juan Suaza', '12345', 5);
INSERT INTO empleados VALUES('1111111112','Juan Salazar', '12345', 5);
INSERT INTO empleados VALUES('1111111113','Edgar Ceron', '12345', 5);
INSERT INTO empleados VALUES('1111111114','Alejandro Martinez', '12345', 5);
INSERT INTO empleados VALUES('1111111115','Fabio Castaneda', '12345', 5);
INSERT INTO empleados VALUES('1111111116','Jhonier Calero', '12345', 5);
INSERT INTO empleados VALUES('1111111117','Joan Tovar', '12345', 5);
INSERT INTO empleados VALUES('1111111118','Juan Moreno', '12345', 5);
INSERT INTO empleados VALUES('1111111119','Annie Munoz', '12345', 5);
INSERT INTO empleados VALUES('1111111110','Camila Saldarriaga', '12345', 5);
INSERT INTO empleados VALUES('1111111121','Sara Munoz', '12345', 3);
INSERT INTO empleados VALUES('1111111122','Jhon Mena', '12345', 3);
INSERT INTO empleados VALUES('1111111123','Esteban Aguirre', '12345', 3);
INSERT INTO empleados VALUES('1111111124','Alisson Arango', '12345', 3);
INSERT INTO empleados VALUES('1111111125','Adriana Andrade', '12345', 3);
INSERT INTO empleados VALUES('1111111126','Daniela Casallas', '12345', 3);
INSERT INTO empleados VALUES('1111111127','Veronica Garcia', '12345', 3);
INSERT INTO empleados VALUES('1111111128','Abraham Andrade', '12345', 3);
INSERT INTO empleados VALUES('1111111129','Juliana Burbano', '12345', 3);
INSERT INTO empleados VALUES('1111111131','Elisa Rubiano', '12345', 3);
INSERT INTO empleados VALUES('1111111132','Lia Rubiano', '12345', 3);
INSERT INTO empleados VALUES('1111111133','Fernando Fandino', '12345', 1);
INSERT INTO empleados VALUES('1111111134','Paola Guzman', '12345', 1);
INSERT INTO empleados VALUES('1111111135','Laura Cruz', '12345', 1);
INSERT INTO empleados VALUES('1111111136','Adriana Gutierrez', '12345', 1);
INSERT INTO empleados VALUES('1111111137','Alexander Martinez', '12345', 1);
INSERT INTO empleados VALUES('1111111138','Alejandro Libreros', '12345', 1);
INSERT INTO empleados VALUES('1111111139','Andres Ramirez', '12345', 1);
INSERT INTO empleados VALUES('1111111141','Erik Lopez', '12345', 1);
INSERT INTO empleados VALUES('1111111142','Juan Viteri', '12345', 1);
INSERT INTO empleados VALUES('1111111143','Camilo Ruiz', '12345', 1);
INSERT INTO empleados VALUES('1111111144','Edwin Gamboa', '12345', 1);
INSERT INTO empleados VALUES('1111111145','Miguel Lopez', '12345', 1);
INSERT INTO empleados VALUES('1111111146','Augusto Rodriguez', '12345', 1);
INSERT INTO empleados VALUES('1111111147','Carmen Rodriguez', '12345', 1);
INSERT INTO empleados VALUES('1111111148','Juan Montoya', '12345', 1);
INSERT INTO empleados VALUES('1111111149','Cristian Diaz', '12345', 1);
INSERT INTO empleados VALUES('1111111151','Camilo Sanchez', '12345', 1);
INSERT INTO empleados VALUES('1111111152','German Cadena', '12345', 1);
INSERT INTO empleados VALUES('1111111153','David Castillo', '12345', 1);
INSERT INTO empleados VALUES('1111111154','Diego Daza', '12345', 1);
INSERT INTO empleados VALUES('1111111155','Nicolas Escobar', '12345', 1);
INSERT INTO empleados VALUES('1111111156','Jorge Gallego', '12345', 1);
INSERT INTO empleados VALUES('1111111157','Camilo Vargas', '12345', 1);
INSERT INTO empleados VALUES('1111111158','Manuel Erazo', '12345', 2);
INSERT INTO empleados VALUES('1111111170','Manuel Erazo', '12345', 4);
INSERT INTO empleados VALUES('1111111159','Jose Renteria', '12345', 4);
INSERT INTO empleados VALUES('1111111161','Jairo Villarrraga', '12345', 4);
INSERT INTO empleados VALUES('1111111162','Ricardo Munoz', '12345', 4);
INSERT INTO empleados VALUES('1111111163','Felipe Diaz', '12345', 4);
INSERT INTO empleados VALUES('1111111164','Jesus Ortiz', '12345', 4);
INSERT INTO empleados VALUES('1111111165','Cesar Ceballos', '12345', 4);
INSERT INTO empleados VALUES('1111111166','Jose Andrade', '12345', 4);
INSERT INTO empleados VALUES('1111111167','Oscar Montoya', '12345', 4);
INSERT INTO empleados VALUES('1111111168','Sebastian Mendez', '12345', 4);
INSERT INTO empleados VALUES('1111111169','Santiago Martinez', '12345', 4);



INSERT INTO estaciones VALUES(1,'Universidades','Cra 100','1111111111');
INSERT INTO estaciones VALUES(2,'Univalle','Cra 100 con Pasoancho','1111111112');
INSERT INTO estaciones VALUES(3,'Buitrera','Calle 5ta','1111111113');
INSERT INTO estaciones VALUES(4,'Melendez','Calle 5ta con 94','1111111114');
INSERT INTO estaciones VALUES(5,'Capri','Calle 5ta con 80','1111111115');
INSERT INTO estaciones VALUES(6,'Caldas','Calle 5ta con 70','1111111116');
INSERT INTO estaciones VALUES(7,'Refugio','Calle 5ta con 66','1111111117');
INSERT INTO estaciones VALUES(8,'Pampalinda','Calle 5ta con 55','1111111118');
INSERT INTO estaciones VALUES(9,'Plaza de toros','Calle 5ta con 50','1111111119');
INSERT INTO estaciones VALUES(10,'Unidad deportiva','Calle 5ta con 46','1111111110');

INSERT INTO rutas VALUES(1,'T31','Ruta troncal');
INSERT INTO rutas VALUES(2,'E21','Ruta expreso 1');
INSERT INTO rutas VALUES(3,'E31','Ruta expreso 2');
INSERT INTO rutas VALUES(4,'E41','Ruta expreso 3');
INSERT INTO rutas VALUES(5,'E27','Ruta expreso 4');

INSERT INTO estaciones_en_ruta VALUES(1,1);
INSERT INTO estaciones_en_ruta VALUES(1,2);
INSERT INTO estaciones_en_ruta VALUES(1,3);
INSERT INTO estaciones_en_ruta VALUES(1,4);
INSERT INTO estaciones_en_ruta VALUES(1,5);
INSERT INTO estaciones_en_ruta VALUES(1,6);
INSERT INTO estaciones_en_ruta VALUES(1,7);
INSERT INTO estaciones_en_ruta VALUES(1,8);
INSERT INTO estaciones_en_ruta VALUES(1,9);
INSERT INTO estaciones_en_ruta VALUES(1,10);
INSERT INTO estaciones_en_ruta VALUES(2,1);
INSERT INTO estaciones_en_ruta VALUES(2,3);
INSERT INTO estaciones_en_ruta VALUES(2,4);
INSERT INTO estaciones_en_ruta VALUES(2,6);
INSERT INTO estaciones_en_ruta VALUES(2,8);
INSERT INTO estaciones_en_ruta VALUES(2,10);
INSERT INTO estaciones_en_ruta VALUES(3,1);
INSERT INTO estaciones_en_ruta VALUES(3,3);
INSERT INTO estaciones_en_ruta VALUES(3,4);
INSERT INTO estaciones_en_ruta VALUES(3,10);
INSERT INTO estaciones_en_ruta VALUES(4,1);
INSERT INTO estaciones_en_ruta VALUES(4,3);
INSERT INTO estaciones_en_ruta VALUES(4,5);
INSERT INTO estaciones_en_ruta VALUES(4,6);
INSERT INTO estaciones_en_ruta VALUES(4,8);
INSERT INTO estaciones_en_ruta VALUES(4,10);
INSERT INTO estaciones_en_ruta VALUES(5,5);
INSERT INTO estaciones_en_ruta VALUES(5,6);
INSERT INTO estaciones_en_ruta VALUES(5,8);
INSERT INTO estaciones_en_ruta VALUES(5,10);

INSERT INTO tipo_bus VALUES(1, 'Alimentador');
INSERT INTO tipo_bus VALUES(2, 'Padron');
INSERT INTO tipo_bus VALUES(3, 'Articulado');

INSERT INTO buses VALUES('AAA111',1);
INSERT INTO buses VALUES('AAA112',1);
INSERT INTO buses VALUES('AAA113',1);
INSERT INTO buses VALUES('AAA114',1);
INSERT INTO buses VALUES('AAA115',2);
INSERT INTO buses VALUES('AAA116',2);
INSERT INTO buses VALUES('AAA117',2);
INSERT INTO buses VALUES('AAA118',2);
INSERT INTO buses VALUES('AAA119',2);
INSERT INTO buses VALUES('AAA121',2);
INSERT INTO buses VALUES('AAA122',3);
INSERT INTO buses VALUES('AAA123',3);
INSERT INTO buses VALUES('AAA124',3);
INSERT INTO buses VALUES('AAA125',3);
INSERT INTO buses VALUES('AAA126',3);
INSERT INTO buses VALUES('AAA127',3);
INSERT INTO buses VALUES('AAA128',3);
INSERT INTO buses VALUES('AAA129',3);
INSERT INTO buses VALUES('AAA131',3);
INSERT INTO buses VALUES('AAA132',3);
INSERT INTO buses VALUES('AAA133',3);

INSERT INTO pasajeros VALUES('0000000001','Martin Lopez');
INSERT INTO pasajeros VALUES('0000000002','Claudia Jimenez');
INSERT INTO pasajeros VALUES('0000000003','Ignacio Cruz');
INSERT INTO pasajeros VALUES('0000000004','Carlina Gutierrez');

INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(1,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(2,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(3,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(1,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(4,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(4,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(3,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(6,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(2,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(7,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(24,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(8,TRUE);
INSERT INTO tarjetas (numero_pasajes, estado_tarjeta) VALUES(0,TRUE);

INSERT INTO tarjeta_personalizada VALUES(1,0,'0000000001',1);
INSERT INTO tarjeta_personalizada VALUES(2,0,'0000000002',2);
INSERT INTO tarjeta_personalizada VALUES(3,0,'0000000003',3);
INSERT INTO tarjeta_personalizada VALUES(4,0,'0000000004',1);

INSERT INTO solicitudes VALUES(1,'',FALSE,'Daños en la estación', 'Las puertas no abren','1111111111');
INSERT INTO solicitudes VALUES(2,'',FALSE,'Daños en los buses', 'El bus AAA111 no tiene aire acondicionado','1111111111');
INSERT INTO solicitudes VALUES(3,'',FALSE,'No hay sistema', 'Esperé 30 minutos para recargar por que no había sistema','1111111114');
INSERT INTO solicitudes VALUES(4,'Se informa al vendedor de su actitud. Se remite a psicología',True,'Actitud del empleado', 'La actitud del empleado Augusto con cédula 1111111146 no es la adecuada','1111111112');

INSERT INTO solicitudes_presentadas VALUES('0000000001', 1,1, current_date);
INSERT INTO solicitudes_presentadas VALUES('0000000004', 2,4, current_date);
INSERT INTO solicitudes_presentadas VALUES('0000000003', 4,3, current_date);
INSERT INTO solicitudes_presentadas VALUES('0000000001', 1,2, current_date);

INSERT INTO conduce VALUES('1111111133','AAA111',7, 11, now());
INSERT INTO conduce VALUES('1111111135','AAA122',7, 11, now());
INSERT INTO conduce VALUES('1111111133','AAA111',1,14, now());
INSERT INTO conduce VALUES('1111111137','AAA132', 7, 11, now());
INSERT INTO conduce VALUES('1111111147','AAA132',11, 14, now());
INSERT INTO conduce VALUES('1111111132','AAA132',14, 20, now());

INSERT INTO rutas_asignadas VALUES('AAA111',1,'1111111133',7, 11,now());
INSERT INTO rutas_asignadas VALUES('AAA122',2,'1111111135',7, 11,now());
INSERT INTO rutas_asignadas VALUES('AAA111',3,'1111111133',11, 14,now());
INSERT INTO rutas_asignadas VALUES('AAA132',4,'1111111137',7, 11,now());
INSERT INTO rutas_asignadas VALUES('AAA132',5,'1111111147',11, 14,now());
INSERT INTO rutas_asignadas VALUES('AAA132',1,'1111111132',14, 20,now());

INSERT INTO venta_tarjetas VALUES('1111111158',1,'2016-11-12', 1);
INSERT INTO venta_tarjetas VALUES('1111111164',2,'2016-1-2', 2);
INSERT INTO venta_tarjetas VALUES('1111111159',3,'2016-3-12', 3);
INSERT INTO venta_tarjetas VALUES('1111111159',4,'2016-5-26', 4);
INSERT INTO venta_tarjetas VALUES('1111111163',5,'2016-5-30', 5);
INSERT INTO venta_tarjetas VALUES('1111111169',6,'2016-1-17', 1);
INSERT INTO venta_tarjetas VALUES('1111111158',7,'2016-11-19', 2);
INSERT INTO venta_tarjetas VALUES('1111111161',8,'2016-12-18', 3);
INSERT INTO venta_tarjetas VALUES('1111111169',9,'2016-6-9', 4);
INSERT INTO venta_tarjetas VALUES('1111111163',10,'2016-6-13', 5);
INSERT INTO venta_tarjetas VALUES('1111111165',11,'2016-8-25', 1);
INSERT INTO venta_tarjetas VALUES('1111111159',12,'2016-10-28', 2);
INSERT INTO venta_tarjetas VALUES('1111111169',13,'2016-12-31', 3);

INSERT INTO bus_abordado VALUES(1,5,now());
INSERT INTO bus_abordado VALUES(1,2,now());
INSERT INTO bus_abordado VALUES(3,2,now());
INSERT INTO bus_abordado VALUES(5,1,now());
INSERT INTO bus_abordado VALUES(2,2,now());
INSERT INTO bus_abordado VALUES(6,4,now());
INSERT INTO bus_abordado VALUES(12,5,now());
INSERT INTO bus_abordado VALUES(9,1,now());
INSERT INTO bus_abordado VALUES(6,2,now());
INSERT INTO bus_abordado VALUES(10,5,now());