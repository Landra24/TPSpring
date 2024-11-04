import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlumnosService } from '../../services/alumnos.service';
import { Alumno } from '../../models/alumno.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form-alumno',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form-alumnos.component.html',
  styleUrls: ['./form-alumnos.component.css']
})
export class FormAlumnosComponent implements OnInit {
  alumno: Alumno = { nombre: '', fechaNacimiento: new Date() };
  alumnoId?: number;

  constructor(
    private alumnosService: AlumnosService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.alumnoId = +this.route.snapshot.paramMap.get('id')!;
    if (this.alumnoId) {
      this.alumnosService.getAlumnoById(this.alumnoId).subscribe((alumno: Alumno) => {
        this.alumno = alumno;
      });
    }
  }

  GuardarAlumno() {
    if (this.alumnoId) {
      this.alumnosService.updateAlumno(this.alumnoId, this.alumno).subscribe(() => {
        this.router.navigate(['/alumnos']);
      });
    } else {
      this.alumnosService.addAlumno(this.alumno).subscribe(() => {
        this.router.navigate(['/alumnos']);
      });
    }
  }

  cancel() {
    this.router.navigate(['/alumnos']);
  }

}