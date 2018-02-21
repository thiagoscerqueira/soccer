import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisaJogadorComponent } from './pesquisa-jogador.component';

describe('PesquisaJogadorComponent', () => {
  let component: PesquisaJogadorComponent;
  let fixture: ComponentFixture<PesquisaJogadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisaJogadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisaJogadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
