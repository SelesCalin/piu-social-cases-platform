import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeOng2Component } from './home-ong2.component';

describe('HomeOng2Component', () => {
  let component: HomeOng2Component;
  let fixture: ComponentFixture<HomeOng2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeOng2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeOng2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
