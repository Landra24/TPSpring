package TP.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "Docentes")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long legajo;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Docente() {
		
	}

	public Docente(Long legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
	}


	public Long getLegajo() {
		return legajo;
	}


	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
