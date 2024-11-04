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

import TP.entidad.Tema;
import TP.servicio.TemaServicio;

@RestController
public class TemaControlador {

	@Autowired
	private TemaServicio temaServicio;
	
	@GetMapping("/temas")
    public List<Tema> listarTodosLosTemas(){
        return temaServicio.listarTodosLosTemas();
    }
	
	@GetMapping("/temas/{id}")
    public ResponseEntity<Tema> listarUnTema(@PathVariable Long id) {
        Optional<Tema> tema = temaServicio.listarUnTema(id);
        return tema.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/temas")
    public ResponseEntity<Tema> agregarTema(@RequestBody Tema tema) {
        Tema nuevoTema = temaServicio.agregarTema(tema);
        return new ResponseEntity<>(nuevoTema, HttpStatus.CREATED);
    }

    @DeleteMapping("/temas/{id}")
    public ResponseEntity<Void> eliminarTema(@PathVariable Long id) {
        temaServicio.eliminarTema(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/temas/{id}")
    public ResponseEntity<Tema> actualizarTema(@PathVariable Long id, @RequestBody Tema nuevoTema) {
        try {
            Tema temaActualizado = temaServicio.actualizarTema(id, nuevoTema);
            return ResponseEntity.ok(temaActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
