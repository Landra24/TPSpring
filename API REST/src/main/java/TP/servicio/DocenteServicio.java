package TP.servicio;

import java.util.List;
import java.util.Optional;

import TP.entidad.Docente;

public interface DocenteServicio {

	public List<Docente> listarTodosLosDocentes();
	
	public Optional<Docente> listarUnDocente(Long legajo);
	
    public Docente agregarDocente(Docente docente);
    
    public void eliminarDocente(Long legajo);
    
    public Docente actualizarDocente(Long legajo, Docente nuevoDocente);
	
}
