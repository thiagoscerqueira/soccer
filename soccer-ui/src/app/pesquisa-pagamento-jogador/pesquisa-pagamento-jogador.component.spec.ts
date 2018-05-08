import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisaPagamentoJogadorComponent } from './pesquisa-pagamento-jogador.component';

describe('PesquisaPagamentoJogadorComponent', () => {
  let component: PesquisaPagamentoJogadorComponent;
  let fixture: ComponentFixture<PesquisaPagamentoJogadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisaPagamentoJogadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisaPagamentoJogadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
