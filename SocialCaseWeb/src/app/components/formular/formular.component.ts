import {AfterViewInit, Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import { DialogUtility } from '@syncfusion/ej2-popups';

@Injectable({
  providedIn: 'root'
})

export class FormularInterface {
  id: string;
}


@Component({
  selector: 'app-formular',
  templateUrl: './formular.component.html',
  styleUrls: ['./formular.component.css'],
  styles: [`
    /*input.ng-pristine{ border-left:10px solid darkblue}*/
    input.ng-valid{ border-left:10px solid green }
    input.ng-invalid{ border-left:10px solid darkblue }`]
})



export class FormularComponent implements OnInit {



  result: string;
  ok: number;
  idUser: string;
  refuz1: boolean;
  refuz2: boolean;
  refuz3: boolean;
  refuz4: boolean;

  accept1: boolean;
  accept2: boolean;
  accept3: boolean;
  accept4: boolean;

  dlg;

  // tslint:disable-next-line:max-line-length
  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, public user: FormularInterface) { }

  ngOnInit() {
    this.idUser = this.user.id = this.route.snapshot.paramMap.get('id');
    console.log(this.user.id);
    if (this.idUser === '1') {
      this.ok = 1;
    } else {
      this.ok = 0;
    }
    this.refuz1 = false;
    this.refuz2 = false;
    this.refuz3 = false;
    this.refuz4 = false;

    this.accept1 = true;
    this.accept2 = true;
    this.accept3 = true;
    this.accept4 = true;


  }

  submitForm(value: any) {
    this.result = value;
    this.ok = 8;


  }

  logout(): void {
    this.router.navigateByUrl('/home');
  }

  openModal(nmb: number) {
    if (nmb === 1) {
     this.ok = 3;
    } else  if (nmb === 2) {
      this.ok = 4;
    } else  if (nmb === 3) {
      this.ok = 5;
    } else  if (nmb === 4) {
      this.ok = 6;
    } else  if (nmb === 5) {
      this.ok = 7;
    }
  }

  onCancel() {
    if (this.idUser === '1') {
    this.ok = 1;
    } else {
      this.ok = 8;
    }
  }

  refuzFunc1() {
    this.refuz1 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz1() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc1.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });

  }

  refuzFunc2() {
    this.refuz2 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz2() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc2.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc3() {
    this.refuz3 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz3() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc3.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc4() {
    this.refuz4 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz4() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc4.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  acceptFunc1() {
    this.accept1 = false;
    this.ok = 1;
    this.dlg.hide();
  }

  onAccept1() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc1.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  acceptFunc2() {
    this.accept2 = false;
    this.ok = 1;
    this.dlg.hide();
  }

  onAccept2() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc2.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  acceptFunc3() {
    this.accept3 = false;
    this.ok = 1;
    this.dlg.hide();
  }

  onAccept3() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc3.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  acceptFunc4() {
    this.accept4 = false;
    this.ok = 1;
  }

  onAccept4() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc4.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }
}
