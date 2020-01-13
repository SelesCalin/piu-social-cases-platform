import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { DialogUtility } from '@syncfusion/ej2-popups';

@Component({
  selector: 'app-login-ong',
  templateUrl: './login-ong.component.html',
  styleUrls: ['./login-ong.component.css']
})
export class LoginOngComponent implements OnInit {


  email: string;
  password: string;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  ongLogin(e): void {
    e.preventDefault();
    if (this.email === 'ong@gmail.com' && this.password === 'ongpass') {
      this.router.navigate(['home/ong']);
    } else if (this.email === 'ong2@gmail.com' && this.password === 'ongpass2') {
      this.router.navigate(['home/ong2']);
    } else {
      DialogUtility.alert({
        title: 'Eroare: Credentiale invalide!',
        content: 'Email/Parola invalide!',
        okButton: {  text: 'Cancel'},
        showCloseIcon: true,
        closeOnEscape: true,
        animationSettings: { effect: 'Zoom' }
      });
    }
  }

}
