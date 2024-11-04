package TP.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TP.entidad.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {

}