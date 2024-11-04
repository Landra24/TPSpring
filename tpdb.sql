CREATE DATABASE IF NOT EXISTS dbtp;
USE dbtp;

-- Tabla para Docente
CREATE TABLE Docentes (
    legajo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
) AUTO_INCREMENT=10000;

-- Tabla para Tema
CREATE TABLE Temas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Tabla para Alumno
CREATE TABLE Alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaNacimiento DATE
);

-- Tabla para Curso
CREATE TABLE Cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tema_id INT,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    docente_legajo BIGINT,
    precio DOUBLE,
    FOREIGN KEY (tema_id) REFERENCES Temas(id),
    FOREIGN KEY (docente_legajo) REFERENCES Docentes(legajo)
);

-- Tabla intermedia para la relación muchos a muchos entre Curso y Alumno
CREATE TABLE Curso_Alumno (
    curso_id INT,
    alumno_id INT,
    PRIMARY KEY (curso_id, alumno_id),
    FOREIGN KEY (curso_id) REFERENCES Cursos(id),
    FOREIGN KEY (alumno_id) REFERENCES Alumnos(id)
);

-- Insertar docentes
INSERT INTO Docentes (legajo, nombre) VALUES
(12345, 'Juan Pérez'),
(67890, 'María Gómez');

-- Insertar temas
INSERT INTO Temas (nombre, descripcion) VALUES
('Matemáticas', 'Curso de introducción a las matemáticas'),
('Programación', 'Curso de introducción a la programación en Java'),
('Historia', 'Estudio de los eventos históricos más relevantes');

-- Insertar alumnos
INSERT INTO Alumnos (nombre, fechaNacimiento) VALUES
('Carlos López', '1990-05-21'),
('Ana Rodríguez', '1995-07-14'),
('Pedro Martínez', '1992-03-09');

-- Insertar cursos
INSERT INTO Cursos (tema_id, fechaInicio, fechaFin, docente_legajo, precio) VALUES
(1, '2024-01-10', '2024-03-10', 12345, 1500.00),  -- Curso de Matemáticas con Juan Pérez
(2, '2024-02-01', '2024-04-01', 67890, 2000.00),  -- Curso de Programación con María Gómez
(3, '2024-03-15', '2024-05-15', 12345, 1800.00);  -- Curso de Historia con Juan Pérez

-- Asignar alumnos a cursos (relación muchos a muchos)
INSERT INTO Curso_Alumno (curso_id, alumno_id) VALUES
(1, 1), -- Carlos López en el curso de Matemáticas
(1, 2), -- Ana Rodríguez en el curso de Matemáticas
(2, 3), -- Pedro Martínez en el curso de Programación
(3, 1), -- Carlos López en el curso de Historia
(3, 3); -- Pedro Martínez en el curso de Historia