import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Curso } from '../models/curso.model';
import { Alumno } from '../models/alumno.model';

@Injectable({
  providedIn: 'root'
})

export class CursosService {
  private ApiURL  = 'http://localhost:8080/cursos';

  constructor(private httpClient: HttpClient) {}

  getCursos(): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(this.ApiURL);
  }

  getCursoById(id: number): Observable<Curso> {
    return this.httpClient.get<Curso>(`${this.ApiURL}/${id}`);
  }

  addCurso(curso: Curso): Observable<Curso> {
    return this.httpClient.post<Curso>(this.ApiURL, curso);
  }

  updateCurso(id: number, curso: Curso): Observable<Object> {
    return this.httpClient.put(`${this.ApiURL}/${id}`, curso);
  }

  deleteCurso(id: number): Observable<Curso> {
    return this.httpClient.delete<Curso>(`${this.ApiURL}/${id}`);
  }

  getCursosPorFechaFin(fecha: string): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(`${this.ApiURL}/fechafin?fecha=${fecha}`);
  }

  getAlumnosDeCursosVigentesPorDocente(legajo: number): Observable<Alumno[]> {
    return this.httpClient.get<Alumno[]>(`${this.ApiURL}/docente/${legajo}/alumnos`);
  }
}