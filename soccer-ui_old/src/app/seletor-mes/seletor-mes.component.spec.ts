import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeletorMesComponent } from './seletor-mes.component';

describe('SeletorMesComponent', () => {
  let component: SeletorMesComponent;
  let fixture: ComponentFixture<SeletorMesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeletorMesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeletorMesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
