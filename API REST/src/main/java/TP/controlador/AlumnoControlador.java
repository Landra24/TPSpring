package TP.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import TP.servicio.AlumnoServicio;
import TP.entidad.Alumno;

@RestController
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio alumnoServicio;
	
	@GetMapping("/alumnos")
    public List<Alumno> listarTodosLosAlumnos(){
        return alumnoServicio.listarTodosLosAlumnos();
    }
	
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id){
        Optional<Alumno> alumno = alumnoServicio.listarUnAlumno(id);
        return alumno.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping("/alumnos")
    public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoServicio.agregarAlumno(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> eliminarAlumno(@PathVariable Long id){
        alumnoServicio.eliminarAlumno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumnoActualizado) {
        try {
            Alumno alumno = alumnoServicio.actualizarAlumno(id, alumnoActualizado);
            return new ResponseEntity<>(alumno, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
