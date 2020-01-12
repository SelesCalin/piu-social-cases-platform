import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {HomeComponent} from './components/home/home.component';
import {FormularComponent} from './components/formular/formular.component';
import {LoginOngComponent} from './components/login-ong/login-ong.component';
import {HomeOngComponent} from './components/home-ong/home-ong.component';
import {VolunteersComponent} from './components/volunteers/volunteers.component';
import {CazuriSocialeComponent} from './components/cazuri-sociale/cazuri-sociale.component';
import {HomeOng2Component} from './components/home-ong2/home-ong2.component';
import {VolunteersOng2Component} from './components/volunteers-ong2/volunteers-ong2.component';



const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'formular/:id', component: FormularComponent},
  {path: 'login/ong', component: LoginOngComponent},
  {path: 'home/ong', component: HomeOngComponent},
   {path: 'home/ong2', component: HomeOng2Component},
  {path: 'voluntari', component: VolunteersComponent},
  {path: 'voluntari2', component: VolunteersOng2Component},
  {path: 'cazuri/:id', component: CazuriSocialeComponent},
  {path: '**', component: HomeComponent}
];

@NgModule({
  imports: [HttpClientModule,
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {  }
