import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDocentesComponent } from './form-docentes.component';

describe('FormDocentesComponent', () => {
  let component: FormDocentesComponent;
  let fixture: ComponentFixture<FormDocentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormDocentesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
