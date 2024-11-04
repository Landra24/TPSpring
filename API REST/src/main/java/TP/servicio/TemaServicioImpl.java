package TP.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TP.entidad.Tema;
import TP.repositorio.TemaRepositorio;

@Service
public class TemaServicioImpl implements TemaServicio {
	
	@Autowired
	private TemaRepositorio temaRepositorio;

	// Método para obtener todos los temas
	@Override
	public List<Tema> listarTodosLosTemas() {
		return temaRepositorio.findAll();
	}
	
	// Método para obtener un tema por ID
	@Override
	public Optional<Tema> listarUnTema(Long id) {
		return temaRepositorio.findById(id);
	}
	
    // Método para agregar un nuevo alumno
	@Override
    public Tema agregarTema(Tema tema) {
        return temaRepositorio.save(tema);
    }

    // Método para eliminar un tema por ID
    public void eliminarTema(Long id) {
        temaRepositorio.deleteById(id);
    }
    
    // Método para actualizar un alumno
	@Override
    public Tema actualizarTema(Long id, Tema nuevoTema) {
        Optional<Tema> temaExistente = temaRepositorio.findById(id);
        if (temaExistente.isPresent()) {
            Tema tema = temaExistente.get();
            tema.setNombre(nuevoTema.getNombre());
            tema.setDescripcion(nuevoTema.getDescripcion());
            return temaRepositorio.save(nuevoTema);
        } else {
            throw new RuntimeException("Tema no encontrado con ID: " + id);
        }
    }
}
