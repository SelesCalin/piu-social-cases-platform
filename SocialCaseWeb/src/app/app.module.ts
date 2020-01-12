import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule, MatCardModule, MatDialogModule, MatFormFieldModule, MatIconModule, MatTableModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { FormularComponent } from './components/formular/formular.component';
import {DialogModule} from '@syncfusion/ej2-angular-popups';
import {LoginOngComponent} from './components/login-ong/login-ong.component';
import {HomeOngComponent} from './components/home-ong/home-ong.component';
import {VolunteersComponent} from './components/volunteers/volunteers.component';
import { CazuriSocialeComponent } from './components/cazuri-sociale/cazuri-sociale.component';
import {NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown';
import {NgSelectModule} from '@ng-select/ng-select';
import { HomeOng2Component } from './components/home-ong2/home-ong2.component';
import {VolunteersOng2Component} from './components/volunteers-ong2/volunteers-ong2.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FormularComponent,
    LoginOngComponent,
    HomeOngComponent,
    VolunteersComponent,
    VolunteersOng2Component,
    CazuriSocialeComponent,
    HomeOng2Component
  ],
  imports: [
    MatButtonModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    MatDialogModule,
    MatIconModule,
    HttpClientModule,
    DialogModule,
    NgMultiSelectDropDownModule.forRoot(),
    NgSelectModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
