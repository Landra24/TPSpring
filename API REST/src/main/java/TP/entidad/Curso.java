package TP.entidad;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "tema_id")
	private Tema tema;
	
	@Column(name = "fechaInicio")
	@Temporal(TemporalType.DATE)
	private LocalDate fechaInicio;
	
	@Column(name = "fechaFin")
	@Temporal(TemporalType.DATE)
	private LocalDate fechaFin;
	
    @ManyToOne
    @JoinColumn(name="docente_legajo")
    private Docente docente;
	
	@Column(name = "precio")
	private Double precio;
	
    @ManyToMany
    @JoinTable(
        name = "Curso_Alumno",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> alumnos;

	public Curso() {
		
	}

	public Curso(Long id, Tema tema, LocalDate fechaInicio, LocalDate fechaFin, Docente docente, Double precio,
			List<Alumno> alumnos) {
		super();
		this.id = id;
		this.tema = tema;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.docente = docente;
		this.precio = precio;
		this.alumnos = alumnos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
