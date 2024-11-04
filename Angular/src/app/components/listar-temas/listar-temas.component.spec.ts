import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarTemasComponent } from './listar-temas.component';

describe('ListarTemasComponent', () => {
  let component: ListarTemasComponent;
  let fixture: ComponentFixture<ListarTemasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarTemasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarTemasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
