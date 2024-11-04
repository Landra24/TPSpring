import { Component, OnInit } from '@angular/core';
import { TemasService } from '../../services/temas.service';
import { Tema } from '../../models/tema.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listar-temas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-temas.component.html',
  styleUrls: ['./listar-temas.component.css']
})
export class ListarTemasComponent implements OnInit {
  tema: Tema[] = [];

  constructor(private temasService: TemasService, private router: Router) {}

  ngOnInit(): void {
    this.temasService.getTemas().subscribe(data => {
      this.tema = data;
    });
  }

  deleteTema(id: number) {
    this.temasService.deleteTema(id).subscribe(() => {
      this.tema = this.tema.filter(tema => tema.id !== id);
    });
  }

  editTema(id: number) {
    this.router.navigate(['/temas/edit', id]);
  }

  addTema() {
    this.router.navigate(['/temas/add']);
  }
}