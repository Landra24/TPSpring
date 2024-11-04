package TP.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TP.entidad.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
