import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alumno } from '../models/alumno.model';

@Injectable({
  providedIn: 'root'
})

export class AlumnosService {
  private ApiURL  = 'http://localhost:8080/alumnos';

  constructor(private httpClient: HttpClient) {}

  getAlumnos(): Observable<Alumno[]> {
    return this.httpClient.get<Alumno[]>(`${this.ApiURL}`);
  }

  getAlumnoById(id: number): Observable<Alumno> {
    return this.httpClient.get<Alumno>(`${this.ApiURL}/${id}`);
  }

  addAlumno(alumno: Alumno): Observable<Object> {
    return this.httpClient.post(`${this.ApiURL}`, alumno);
  }

  updateAlumno(id: number, alumno: Alumno): Observable<Object> {
    return this.httpClient.put(`${this.ApiURL}/${id}`, alumno);
  }

  deleteAlumno(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.ApiURL}/${id}`);
  }
}