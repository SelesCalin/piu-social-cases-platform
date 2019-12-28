import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeOngComponent } from './home-ong.component';

describe('HomeOngComponent', () => {
  let component: HomeOngComponent;
  let fixture: ComponentFixture<HomeOngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeOngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeOngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
