import { Tema } from './tema.model';
import { Docente } from './docente.model';
import { Alumno } from './alumno.model';

export interface Curso {
    id?: number;
    tema: Tema;
    fechaInicio: Date;
    fechaFin: Date;
    docente: Docente;
    precio: number;
    alumnos: Alumno[];
  }