package TP.controlador;

import java.util.*;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import TP.entidad.Alumno;
import TP.entidad.Curso;
import TP.servicio.CursoServicio;

@RestController
public class CursoControlador {

	@Autowired
	private CursoServicio cursoServicio;
	
	@GetMapping("/cursos")
    public List<Curso> listarTodosLosCursos(){
        return cursoServicio.listarTodosLosCursos();
    }
	
	@GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> listarUnCurso(@PathVariable Long id) {
        Optional<Curso> curso = cursoServicio.listarUnCurso(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoServicio.agregarCurso(curso);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoServicio.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso nuevoCurso) {
        try {
            Curso cursoActualizado = cursoServicio.actualizarCurso(id, nuevoCurso);
            return ResponseEntity.ok(cursoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/cursos/fechafin")
    public List<Curso> listarCursosPorFechaFin(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return cursoServicio.listarCursosPorFechaFin(fechaFin);
    }

    
    @GetMapping("/cursos/docente/{legajo}/alumnos")
    public List<Alumno> listarAlumnosDelCursoVigenteDeDocente(@PathVariable Long legajo) {
        return cursoServicio.listarAlumnosDelCursoVigenteDeDocente(legajo);
    }
}
