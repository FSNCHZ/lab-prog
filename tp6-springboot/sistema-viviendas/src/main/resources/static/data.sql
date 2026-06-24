DELETE FROM viviendas;
DELETE FROM barrios;

INSERT INTO barrios (id, nombre) VALUES
(1, 'Belgrano'),
(2, 'Centro'),
(3, '2 de Abril'),
(4, 'Evita'),
(5, 'Fatima');
(6, "Del Carmén");
(7, "San Benito");

INSERT INTO viviendas (id, calle, nro, titular, numhabitantes, barrio_id) VALUES
(1,  'Rivadavia', 1230,'Juan Pérez', 4, 2),
(2,  'San Martín', 456, 'María López', 2, 2),
(3,  'Mitre', 789, 'Carlos Rodríguez', 5, 2),
(4,  'Belgrano', 1010, 'Ana Gómez', 3, 1),
(5,  'Sarmiento', 321, 'Luis Fernández', 6, 2),
(6,  'Mariano Moreno', 654, 'Sofía Torres', 1, 2),
(7,  'Darwin', 987, 'Pablo Díaz', 4, 6),
(8,  'Libertad', 1122, 'Laura Martínez', 2, 6),
(9,  'Balbin', 333, 'Diego Romero', 3, 4),
(10, 'Calle 13', 777, 'Valeria Suárez', 5, 7);