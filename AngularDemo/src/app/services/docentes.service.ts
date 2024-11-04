import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Docente } from '../models/docente.model';

@Injectable({
  providedIn: 'root'
})

export class DocentesService {
  private ApiURL  = 'http://localhost:8080/docentes';

  constructor(private httpClient: HttpClient) {}

  getDocentes(): Observable<Docente[]> {
    return this.httpClient.get<Docente[]>(`${this.ApiURL}`);
  }

  getDocenteByLegajo(legajo: number): Observable<Docente> {
    return this.httpClient.get<Docente>(`${this.ApiURL}/${legajo}`);
  }

  addDocente(docente: Docente): Observable<Object> {
    return this.httpClient.post(`${this.ApiURL}`, docente);
  }

  updateDocente(legajo: number, docente: Docente): Observable<Object> {
    return this.httpClient.put(`${this.ApiURL}/${legajo}`, docente);
  }

  deleteDocente(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.ApiURL}/${id}`);
  }

}
