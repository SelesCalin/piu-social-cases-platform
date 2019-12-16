import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { DialogUtility } from '@syncfusion/ej2-popups';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router ) { }

  username: string;
  password: string;

  ngOnInit() {}

  login(e): void {
      e.preventDefault();
      if (this.username === 'admin@gmail.com' && this.password === 'admin') {
        this.router.navigate(['formular', 1]);
      } else if (this.username === 'user@gmail.com' && this.password === 'user1') {
        this.router.navigate(['formular', 2]);
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
