import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeletorMesAnoComponent } from './seletor-mes-ano.component';

describe('SeletorMesAnoComponent', () => {
  let component: SeletorMesAnoComponent;
  let fixture: ComponentFixture<SeletorMesAnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeletorMesAnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeletorMesAnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
