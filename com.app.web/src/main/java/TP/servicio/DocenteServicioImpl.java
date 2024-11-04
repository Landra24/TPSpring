package TP.servicio;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TP.entidad.Docente;
import TP.repositorio.DocenteRepositorio;

@Service
public class DocenteServicioImpl implements DocenteServicio {

	@Autowired
	private DocenteRepositorio docenteRepositorio;
	
	// Método para obtener todos los docentes
	@Override
	public List<Docente> listarTodosLosDocentes() {
		return docenteRepositorio.findAll();
	}
	
	// Método para obtener un docente por ID
	@Override
	public Optional<Docente> listarUnDocente(Long legajo) {
		return docenteRepositorio.findById(legajo);
	}
	
    // Método para agregar un nuevo docente
	@Override
    public Docente agregarDocente(Docente docente) {
        return docenteRepositorio.save(docente);
    }
	
    // Método para eliminar un docente por ID
	@Override
    public void eliminarDocente(Long legajo) {
        docenteRepositorio.deleteById(legajo);
    }
	
    // Método para actualizar un docente
	@Override
    public Docente actualizarDocente(Long legajo, Docente nuevoDocente) {
        Optional<Docente> docenteExistente = docenteRepositorio.findById(legajo);
        if (docenteExistente.isPresent()) {
            Docente docente = docenteExistente.get();
            docente.setNombre(nuevoDocente.getNombre());
            return docenteRepositorio.save(docente);
        } else {
            throw new RuntimeException("Docente no encontrado con legajo: " + legajo);
        }
    }
}
