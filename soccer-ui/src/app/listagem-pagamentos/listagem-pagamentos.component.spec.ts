import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemPagamentosComponent } from './listagem-pagamentos.component';

describe('ListagemPagamentosComponent', () => {
  let component: ListagemPagamentosComponent;
  let fixture: ComponentFixture<ListagemPagamentosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListagemPagamentosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListagemPagamentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
