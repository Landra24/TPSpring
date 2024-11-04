import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tema } from '../models/tema.model';

@Injectable({
  providedIn: 'root'
})

export class TemasService {
  private ApiURL  = 'http://localhost:8080/temas';

  constructor(private httpClient: HttpClient) {}

  getTemas(): Observable<Tema[]> {
    return this.httpClient.get<Tema[]>(this.ApiURL);
  }

  getTemaById(id: number): Observable<Tema> {
    return this.httpClient.get<Tema>(`${this.ApiURL}/${id}`);
  }

  addTema(tema: Tema): Observable<Tema> {
    return this.httpClient.post<Tema>(this.ApiURL, tema);
  }

  updateTema(id: number, tema: Tema): Observable<Object> {
    return this.httpClient.put(`${this.ApiURL}/${id}`, tema);
  }

  deleteTema(id: number): Observable<Tema> {
    return this.httpClient.delete<Tema>(`${this.ApiURL}/${id}`);
  }

}