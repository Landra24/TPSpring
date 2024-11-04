package TP.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TP.entidad.Docente;

@Repository
public interface DocenteRepositorio extends JpaRepository<Docente, Long>{

}
