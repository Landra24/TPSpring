import { Component, OnInit } from '@angular/core';
import { DocentesService } from '../../services/docentes.service';
import { Docente } from '../../models/docente.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listar-docentes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-docentes.component.html',
  styleUrls: ['./listar-docentes.component.css']
})
export class ListarDocentesComponent implements OnInit {
  docente: Docente[] = [];

  constructor(private docentesService: DocentesService, private router: Router) {}

  ngOnInit(): void {
    this.docentesService.getDocentes().subscribe(data => {
      this.docente = data;
    });
  }

  deleteDocente(legajo: number) {
    this.docentesService.deleteDocente(legajo).subscribe(() => {
      this.docente = this.docente.filter(docente => docente.legajo !== legajo);
    });
  }

  editDocente(legajo: number) {
    this.router.navigate(['/docentes/edit', legajo]);
  }

  addDocente() {
    this.router.navigate(['/docentes/add']);
  }
}