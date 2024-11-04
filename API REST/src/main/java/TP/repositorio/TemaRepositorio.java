package TP.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TP.entidad.Tema;

@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long>{

}