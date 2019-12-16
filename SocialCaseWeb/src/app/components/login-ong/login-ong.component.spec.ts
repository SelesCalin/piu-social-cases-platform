import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginOngComponent } from './login-ong.component';

describe('LoginOngComponent', () => {
  let component: LoginOngComponent;
  let fixture: ComponentFixture<LoginOngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginOngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginOngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
