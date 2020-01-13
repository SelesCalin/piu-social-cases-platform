import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteersOng2Component } from './volunteers-ong2.component';

describe('VolunteersOng2Component', () => {
  let component: VolunteersOng2Component;
  let fixture: ComponentFixture<VolunteersOng2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VolunteersOng2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VolunteersOng2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
