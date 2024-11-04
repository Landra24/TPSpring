import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { DocentesService } from '../../services/docentes.service';
import { FormsModule } from '@angular/forms';
import { Docente } from '../../models/docente.model';

@Component({
  selector: 'app-form-docentes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-docentes.component.html',
  styleUrls: ['./form-docentes.component.css']
})

export class FormDocentesComponent implements OnInit {
  docente: Docente = { nombre: '' };
  docenteLegajo?: number;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private docentesService: DocentesService,
  ) {}

  ngOnInit(): void {
    this.docenteLegajo = +this.route.snapshot.paramMap.get('legajo')!;
    if (this.docenteLegajo) {
      this.docentesService.getDocenteByLegajo(this.docenteLegajo).subscribe((docente: Docente) => {
        this.docente = docente;
      });
   }
  }

  GuardarDocente(): void {
    if (this.docenteLegajo) {
      this.docentesService.updateDocente(this.docenteLegajo, this.docente).subscribe(() => {
        this.router.navigate(['/docentes']);
      });
    } else {
      this.docentesService.addDocente(this.docente).subscribe(() => {
        this.router.navigate(['/docentes']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/docentes']);
  }
}