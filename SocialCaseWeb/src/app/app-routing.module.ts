import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {HomeComponent} from './components/home/home.component';
import {FormularComponent} from './components/formular/formular.component';
import {LoginOngComponent} from './components/login-ong/login-ong.component';
import {HomeOngComponent} from './components/home-ong/home-ong.component';
import {VolunteersComponent} from './components/volunteers/volunteers.component';
import {CazuriSocialeComponent} from './components/cazuri-sociale/cazuri-sociale.component';



const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'formular/:id', component: FormularComponent},
  {path: 'login/ong', component: LoginOngComponent},
  {path: 'home/ong', component: HomeOngComponent},
  {path: 'voluntari', component: VolunteersComponent},
  {path: 'cazuri', component: CazuriSocialeComponent},
  {path: '**', component: HomeComponent}
];

@NgModule({
  imports: [HttpClientModule,
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {  }
