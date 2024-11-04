import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { TemasService } from '../../services/temas.service';
import { FormsModule } from '@angular/forms';
import { Tema } from '../../models/tema.model';

@Component({
  selector: 'app-form-cursos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-temas.component.html',
  styleUrls: ['./form-temas.component.css']
})

export class FormTemasComponent implements OnInit {
  tema: Tema = { nombre: '', descripcion: '' };
  temaId?: number;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private temasService: TemasService, 
  ) {}

  ngOnInit(): void {
    this.temaId = +this.route.snapshot.paramMap.get('id')!;
    if (this.temaId) {
       this.temasService.getTemaById(this.temaId).subscribe((tema: Tema) => {
         this.tema = tema;
       });
     }
  }

  GuardarTema(): void {
    if (this.temaId) {
      this.temasService.updateTema(this.temaId, this.tema).subscribe(() => {
        this.router.navigate(['/temas']);
      });
    } else {
      this.temasService.addTema(this.tema).subscribe(() => {
        this.router.navigate(['/temas']);
      });
    }
  }
  
  cancel(): void {
    this.router.navigate(['/temas']);
  }
}