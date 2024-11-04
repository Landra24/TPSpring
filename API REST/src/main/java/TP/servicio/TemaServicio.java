package TP.servicio;

import java.util.*;

import TP.entidad.Tema;

public interface TemaServicio {

	public List<Tema> listarTodosLosTemas();
	
	public Optional<Tema> listarUnTema(Long id);

	public Tema agregarTema(Tema tema);
	
    public void eliminarTema(Long id);
    
    public Tema actualizarTema(Long id, Tema nuevoTema);
}
