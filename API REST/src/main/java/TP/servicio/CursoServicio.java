package TP.servicio;

import java.time.LocalDate;
import java.util.*;

import TP.entidad.Alumno;
import TP.entidad.Curso;

public interface CursoServicio {

	public List<Curso> listarTodosLosCursos();
	
	public Optional<Curso> listarUnCurso(Long id);

	public Curso agregarCurso(Curso curso);
	
	public void eliminarCurso(Long id);
	
	public Curso actualizarCurso(Long id, Curso nuevoCurso);
	
	public List<Curso> listarCursosPorFechaFin(LocalDate fechaFin);
	
	public List<Alumno> listarAlumnosDelCursoVigenteDeDocente(Long legajo);
}