package TP.servicio;

import java.util.*;

import TP.entidad.Alumno;

public interface AlumnoServicio {

	public List<Alumno> listarTodosLosAlumnos();
	
    public Alumno agregarAlumno(Alumno alumno);
    
	public Optional<Alumno> listarUnAlumno(Long id);

    public void eliminarAlumno(Long id);
	
    public Alumno actualizarAlumno(Long legajo, Alumno nuevoAlumno);    
}