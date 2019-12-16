import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CazuriSocialeComponent } from './cazuri-sociale.component';

describe('CazuriSocialeComponent', () => {
  let component: CazuriSocialeComponent;
  let fixture: ComponentFixture<CazuriSocialeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CazuriSocialeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CazuriSocialeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
