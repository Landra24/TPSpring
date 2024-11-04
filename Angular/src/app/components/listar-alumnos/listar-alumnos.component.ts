import { Component, OnInit } from '@angular/core';
import { AlumnosService } from '../../services/alumnos.service';
import { Alumno } from '../../models/alumno.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-alumnos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-alumnos.component.html',
  styleUrl: './listar-alumnos.component.css'
})

export class ListarAlumnosComponent implements OnInit {
  alumnos: Alumno[] = [];

  constructor(private alumnosService: AlumnosService, private router: Router) { }

  ngOnInit(): void {
    this.alumnosService.getAlumnos().subscribe(data => {
      this.alumnos = data;
    });
  }

  deleteAlumno(id: number) {
    this.alumnosService.deleteAlumno(id).subscribe(() => {
      this.alumnos = this.alumnos.filter(alumno => alumno.id !== id);
    });
  }

  editAlumno(id: number) {
    this.router.navigate(['/alumnos/edit', id]);
  }

  addAlumno() {
    this.router.navigate(['/alumnos/add']);
  }

}
