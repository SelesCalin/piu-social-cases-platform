import {AfterViewInit, Component, EventEmitter, Inject, Injectable, OnInit, Output, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import { DialogUtility } from '@syncfusion/ej2-popups';
import {CazuriSocialeComponent} from '../cazuri-sociale/cazuri-sociale.component';

@Injectable({
  providedIn: 'root'
})

export class FormularInterface {
  id: string;
}


@Component({
  providers: [CazuriSocialeComponent],
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
  refuz5: boolean;
  refuz6: boolean;
  refuz7: boolean;

  accept1: boolean;
  accept2: boolean;
  accept3: boolean;
  accept4: boolean;
  accept5: boolean;
  accept6: boolean;
  accept7: boolean;

  dlg;
  selected1: string;
  selected2: string;
  selected3: string;
  selected4: string;
  selected5: string;
  selected6: string;
  selected7: string;

  sel1: string;
  message: string;
  notif: boolean;


  // tslint:disable-next-line:max-line-length
  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, public user: FormularInterface,
              @Inject(CazuriSocialeComponent) private cazS) { }

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
    this.refuz5 = false;
    this.refuz6 = false;
    this.refuz7 = false;

    this.accept1 = true;
    this.accept2 = true;
    this.accept3 = true;
    this.accept4 = true;
    this.accept5 = true;
    this.accept6 = true;
    this.accept7 = true;

    this.selected1 = '';
    this.selected2 = '';
    this.selected3 = '';
    this.selected4 = '';
    this.selected5 = '';
    this.selected6 = '';
    this.selected7 = '';
    this.notif = false;
  }

  submitForm() {
    // this.result = value;
    // this.ok = 8;
    this.subm();
    this.refresh();

  }

  refresh(): void {
    window.location.reload();
  }

  subm() {

    this.dlg = DialogUtility.alert({
      content: 'Cazul a fost adaugat!',
      okButton: {
        text: 'OK'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
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
    } else  if (nmb === 6) {
      this.ok = 112;
    } else  if (nmb === 7) {
      this.ok = 113;
    } else  if (nmb === 8) {
      this.ok = 114;
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

  refuzFunc5() {
    this.refuz5 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz5() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc5.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc6() {
    this.refuz6 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz6() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc6.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc7() {
    this.refuz7 = true;
    this.ok = 1;
    this.dlg.hide();
  }

  onRefuz7() {
    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc7.bind(this)},
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
    // this.messageEvent.emit(this.selected1);
    // console.log(this.selected1);

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
    this.dlg.hide();

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

  acceptFunc5() {
    this.accept5 = false;
    this.ok = 1;
    this.dlg.hide();

  }

  onAccept5() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc5.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }
  acceptFunc6() {
    this.accept6 = false;
    this.ok = 1;
    this.dlg.hide();

  }

  onAccept6() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc6.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }
  acceptFunc7() {
    this.accept7 = false;
    this.ok = 1;
    this.dlg.hide();

  }

  onAccept7() {
    this.dlg = DialogUtility.confirm({
      title: 'Confirmare',
      content: 'Acest pas nu mai poate fi editat. Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Confirm', click: this.acceptFunc7.bind(this)},
      cancelButton: {text: 'Cancel'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  selectChangeHandler1(event: any): string {
    this.selected1 = event.target.value;
    return this.selected1;
  }

  selectChangeHandler2(event: any) {
    this.selected2 = event.target.value;
  }

  selectChangeHandler3(event: any) {
    this.selected3 = event.target.value;
  }

  selectChangeHandler4(event: any) {
    this.selected4 = event.target.value;
  }

  selectChangeHandler5(event: any) {
    this.selected5 = event.target.value;
  }

  selectChangeHandler6(event: any) {
    this.selected6 = event.target.value;
  }

  selectChangeHandler7(event: any) {
    this.selected7 = event.target.value;
  }

  notificationFunc() {
    this.notif = true;
  }

}
