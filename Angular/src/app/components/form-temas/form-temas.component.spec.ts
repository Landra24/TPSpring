import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTemasComponent } from './form-temas.component';

describe('FormTemasComponent', () => {
  let component: FormTemasComponent;
  let fixture: ComponentFixture<FormTemasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormTemasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormTemasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
