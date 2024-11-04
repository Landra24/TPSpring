import { Routes } from '@angular/router';
import { ListarAlumnosComponent } from './components/listar-alumnos/listar-alumnos.component';
import { FormAlumnosComponent } from './components/form-alumnos/form-alumnos.component';
import { ListarDocentesComponent } from './components/listar-docentes/listar-docentes.component';
import { FormDocentesComponent } from './components/form-docentes/form-docentes.component';
import { ListarTemasComponent } from './components/listar-temas/listar-temas.component';
import { FormTemasComponent } from './components/form-temas/form-temas.component';
import { ListarCursosComponent } from './components/listar-cursos/listar-cursos.component';
import { FormCursosComponent } from './components/form-cursos/form-cursos.component';
export const routes: Routes = [
    { path: 'alumnos', component: ListarAlumnosComponent },
    { path: 'alumnos/add', component: FormAlumnosComponent },
    { path: 'alumnos/edit/:id', component: FormAlumnosComponent },
    { path: 'temas', component: ListarTemasComponent},
    { path: 'temas/add', component: FormTemasComponent},
    { path: 'temas/edit/:id', component: FormTemasComponent},
    { path: 'docentes', component: ListarDocentesComponent },
    { path: 'docentes/add', component: FormDocentesComponent },
    { path: 'docentes/edit/:legajo', component: FormDocentesComponent },
    { path: 'cursos', component: ListarCursosComponent },
    { path: 'cursos/add', component: FormCursosComponent },
    { path: 'cursos/edit/:id', component: FormCursosComponent },
    { path: '**', redirectTo: 'alumnos', pathMatch: 'full' },
  ];