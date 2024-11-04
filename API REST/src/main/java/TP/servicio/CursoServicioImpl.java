package TP.servicio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TP.entidad.Alumno;
import TP.entidad.Curso;
import TP.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {
	
	@Autowired
	private CursoRepositorio cursoRepositorio;

	// Método para obtener todos los cursos 
	@Override
	public List<Curso> listarTodosLosCursos() {
		return cursoRepositorio.findAll();
	}
	
	// Método para obtener un curso por ID
	@Override
	public Optional<Curso> listarUnCurso(Long id) {
		return cursoRepositorio.findById(id);
	}
	
    // Método para agregar un nuevo curso
	@Override
    public Curso agregarCurso(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    // Método para eliminar un curso por ID
	@Override
    public void eliminarCurso(Long id) {
        cursoRepositorio.deleteById(id);
    }
    
    // Método para actualizar un curso
	@Override
    public Curso actualizarCurso(Long id, Curso nuevoCurso) {
        Optional<Curso> cursoExistente = cursoRepositorio.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setTema(nuevoCurso.getTema());
            curso.setFechaInicio(nuevoCurso.getFechaInicio());
            curso.setFechaFin(nuevoCurso.getFechaFin());
            curso.setDocente(nuevoCurso.getDocente());
            curso.setPrecio(nuevoCurso.getPrecio());
            curso.setAlumnos(nuevoCurso.getAlumnos());
            return cursoRepositorio.save(nuevoCurso);
        } else {
            throw new RuntimeException("Tema no encontrado con ID: " + id);
        }
    }
	
	
	@Override
    public List<Curso> listarCursosPorFechaFin(LocalDate fechaFin) {
        return cursoRepositorio.findAll().stream()
                .filter(curso -> curso.getFechaFin().equals(fechaFin))
                .collect(Collectors.toList());
    }
	
	
	@Override
	public List<Alumno> listarAlumnosDelCursoVigenteDeDocente(Long legajo) {
		LocalDate today = LocalDate.now();
		 return cursoRepositorio.findAll().stream()
		            .filter(curso -> curso.getDocente().getLegajo().equals(legajo) 
		                             && curso.getFechaFin().isAfter(today))
		            .flatMap(curso -> curso.getAlumnos().stream())
		            .collect(Collectors.toList());
	}
}
