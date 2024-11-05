import { Component, OnInit } from '@angular/core';
import { CursosService } from '../../services/cursos.service';
import { DocentesService } from '../../services/docentes.service';
import { Curso } from '../../models/curso.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Alumno } from '../../models/alumno.model';
import { Docente } from '../../models/docente.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-cursos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './listar-cursos.component.html',
  styleUrl: './listar-cursos.component.css'
})

export class ListarCursosComponent implements OnInit {
  cursos: Curso[] = [];
  cursosFiltrados: Curso[] = [];
  fechaFin: Date = new Date();
  docentes: Docente[] = [];
  selectedDocenteLegajo: number | null = null;
  alumnosFiltrados: Alumno[] = [];
  docentes$: Observable<Docente[]> | undefined;

  constructor(private cursosService: CursosService, private router: Router, private docentesService: DocentesService) { }

  ngOnInit(): void {
    this.cursosService.getCursos().subscribe(data => {
      this.cursos = data;
    });

    this.docentesService.getDocentes().subscribe(data => {
      this.docentes = data;
    });

  }

  deleteCurso(id: number) {
    this.cursosService.deleteCurso(id).subscribe(() => {
      this.cursos = this.cursos.filter(curso => curso.id !== id);
    });
  }

  editCurso(id: number) {
    this.router.navigate(['/cursos/edit', id]);
  }

  addCurso() {
    this.router.navigate(['/cursos/add']);
  }

  buscarCursosPorFecha() {
    if (!this.fechaFin) {
      console.error("No se ha seleccionado ninguna fecha.");
      return;
    }
  
    const fechaFormateada = new Date(this.fechaFin).toISOString().split('T')[0];
  
    this.cursosService.getCursosPorFechaFin(fechaFormateada).subscribe(
      (data) => {
        this.cursosFiltrados = data;
      },
      (error) => {
        console.error('Error al buscar los cursos por fecha:', error);
      }
    );
  }

  buscarAlumnosPorDocente() {
    if (!this.selectedDocenteLegajo) {
      console.error("No se ha seleccionado ningún docente.");
      return;
    }
  
    this.cursosService.getAlumnosDeCursosVigentesPorDocente(this.selectedDocenteLegajo).subscribe(
      (data) => {
        this.alumnosFiltrados = data.filter(
          (alumno, index, self) =>
            index === self.findIndex((a) => a.id === alumno.id)
        );
      },
      (error) => {
        console.error('Error al buscar los alumnos por docente:', error);
      }
    );
  }

}
