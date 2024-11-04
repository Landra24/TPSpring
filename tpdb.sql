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