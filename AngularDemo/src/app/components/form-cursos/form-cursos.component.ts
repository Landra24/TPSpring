import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CursosService } from '../../services/cursos.service';
import { TemasService } from '../../services/temas.service';
import { DocentesService } from '../../services/docentes.service';
import { Curso } from '../../models/curso.model';
import { Tema } from '../../models/tema.model';
import { Alumno } from '../../models/alumno.model';
import { Docente } from '../../models/docente.model';
import { CommonModule } from '@angular/common';
import { AlumnosService } from '../../services/alumnos.service';

@Component({
  selector: 'app-form-curso',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form-cursos.component.html',
  styleUrls: ['./form-cursos.component.css']
})
export class FormCursosComponent implements OnInit { 
   
  curso: Curso = { 
    tema: { id: undefined, nombre: '', descripcion: '' },
    fechaInicio: new Date(),
    fechaFin: new Date(),
    docente: { legajo: undefined, nombre: '' },
    precio: 0,
    alumnos: [{ id: undefined, nombre: '', fechaNacimiento: new Date() }]
  };
  
  cursoId?: number;
  temas: Tema[] = [];
  docentes: Docente[] = [];
  alumnos: Alumno[] = [];
  selectedAlumno?: Alumno;

  constructor(
    private cursosService: CursosService,
    private temasService: TemasService,
    private docentesService: DocentesService,
    private alumnosService: AlumnosService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cursoId = +this.route.snapshot.paramMap.get('id')!;
    
    this.temasService.getTemas().subscribe((temas: Tema[]) => {
      this.temas = temas;
    });
    
    this.docentesService.getDocentes().subscribe((docentes: Docente[]) => {
      this.docentes = docentes;
    });

    this.alumnosService.getAlumnos().subscribe((alumnos: Alumno[]) => {
      this.alumnos = alumnos;
    });

    if (this.cursoId) {
      this.cursosService.getCursoById(this.cursoId).subscribe((curso: Curso) => {
        this.curso = curso;
      });
    }
  }

  GuardarCurso(): void {
    if (this.cursoId) {
      this.cursosService.updateCurso(this.cursoId, this.curso).subscribe(() => {
        this.router.navigate(['/cursos']);
      });
    } else {
      this.cursosService.addCurso(this.curso).subscribe(() => {
        this.router.navigate(['/cursos']);
      });
    }
  }

  cancel() {
    this.router.navigate(['/cursos']);
  }

  addAlumno(): void {
    if (this.selectedAlumno) {
      this.curso.alumnos.push(this.selectedAlumno);
      this.selectedAlumno = undefined;
    }
  }

  removeAlumno(alumno: Alumno): void {
    this.curso.alumnos = this.curso.alumnos.filter(a => a.id !== alumno.id);
  }
}
