package TP.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import TP.entidad.Docente;
import TP.servicio.DocenteServicio;

@RestController
public class DocenteControlador {

	@Autowired
	private DocenteServicio docenteServicio;
	
	@GetMapping("/docentes")
    public List<Docente> listarTodosLosDocentes(){
        return docenteServicio.listarTodosLosDocentes();
    }

    @GetMapping("/docentes/{legajo}")
    public ResponseEntity<Docente> obtenerDocentePorLegajo(@PathVariable Long legajo) {
        Optional<Docente> docente = docenteServicio.listarUnDocente(legajo);
        if (docente.isPresent()) {
            return ResponseEntity.ok(docente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/docentes")
    public ResponseEntity<Docente> agregarDocente(@RequestBody Docente docente) {
        Docente nuevoDocente = docenteServicio.agregarDocente(docente);
        return ResponseEntity.ok(nuevoDocente);
    }

    @DeleteMapping("/docentes/{legajo}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long legajo) {
        try {
            docenteServicio.eliminarDocente(legajo);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/docentes/{legajo}")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Long legajo, @RequestBody Docente nuevoDocente) {
        try {
            Docente docenteActualizado = docenteServicio.actualizarDocente(legajo, nuevoDocente);
            return ResponseEntity.ok(docenteActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
}
