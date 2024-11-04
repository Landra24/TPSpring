package TP.servicio;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TP.entidad.Alumno;
import TP.repositorio.AlumnoRepositorio;

@Service
public class AlumnoServicioImpl implements AlumnoServicio {

	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	// Método para obtener todos los alumnos
	@Override
	public List<Alumno> listarTodosLosAlumnos() {
		return alumnoRepositorio.findAll();
	}
	
	// Método para obtener un alumno por ID
	@Override
	public Optional<Alumno> listarUnAlumno(Long id) {
		return alumnoRepositorio.findById(id);
	}
	
    // Método para agregar un nuevo alumno
	@Override
    public Alumno agregarAlumno(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    // Método para eliminar un alumno por ID
    public void eliminarAlumno(Long id) {
        alumnoRepositorio.deleteById(id);
    }
    
    // Método para actualizar un alumno
	@Override
    public Alumno actualizarAlumno(Long id, Alumno nuevoAlumno) {
        Optional<Alumno> alumnoExistente = alumnoRepositorio.findById(id);
        if (alumnoExistente.isPresent()) {
            Alumno alumno = alumnoExistente.get();
            alumno.setNombre(nuevoAlumno.getNombre());
            alumno.setFechaNacimiento(nuevoAlumno.getFechaNacimiento());
            return alumnoRepositorio.save(nuevoAlumno);
        } else {
            throw new RuntimeException("Alumno no encontrado con ID: " + id);
        }
    }
}

