import { Component, OnInit } from '@angular/core';
import { DialogUtility } from '@syncfusion/ej2-popups';



@Component({
  selector: 'app-cazuri-sociale',
  templateUrl: './cazuri-sociale.component.html',
  styleUrls: ['./cazuri-sociale.component.css']
})
export class CazuriSocialeComponent implements OnInit {

  private dlg;

  constructor() { }

  ok1: boolean;
  nmb1: number;
  display: boolean;
  divId: number;

  ok: boolean;
  nmb: number;
  show: number;

  sterge1: boolean;
  sterge2: boolean;
  sterge3: boolean;
  sterge4: boolean;
  sterge5: boolean;
  sterge6: boolean;

  del1: boolean;
  del2: boolean;
  del3: boolean;

  refuz1: boolean;
  refuz2: boolean;
  refuz3: boolean;

  accept1: boolean;
  accept11: boolean;
  accept2: boolean;
  accept3: boolean;

  fillData1: boolean;
  fillData2: boolean;
  fillData3: boolean;

  ngOnInit() {
    this.ok1 = true;
    // this.display = true;

    this.ok = true;
    this.show = 1;
    this.divId = 1;

    this.del1 = false;
    this.del2 = false;
    this.del3 = false;

    this.sterge1 = false;
    this.sterge2 = false;
    this.sterge3 = false;
    this.sterge4 = false;
    this.sterge5 = false;
    this.sterge6 = false;

    this.refuz1 = false;
    this.refuz2 = false;
    this.refuz3 = false;

    this.accept1 = true;
    this.accept11 = false;
    this.accept2 = true;
    this.accept3 = true;

  }


  openDetails1(nr: number) {
    this.ok1 = false;
    this.nmb1 = nr;
  }

  onBack1() {
    this.ok1 = true;
  }

  setShow() {
    this.display = false;
    this.divId = 0;
  }

  setShow2() {
    this.display = true;
    this.divId = 0;
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

  refuzFunc1() {
    this.refuz1 = true;
    this.show = 1;
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

  refuzFunc2() {
    this.refuz2 = true;
    this.show = 1;
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

  refuzFunc3() {
    this.refuz3 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onAccept1() {
    this.accept1 = false;
    this.show = 1;
    this.accept11 = true;
    this.fillData1 = true;
  }

  onAccept2() {
    this.accept2 = false;
    this.show = 1;
    this.fillData2 = true;

  }

  onAccept3() {
    this.accept3 = false;
    this.show = 1;
    this.fillData3 = true;
  }

  openDetails(nr: number) {
    this.ok = false;
    this.nmb = nr;
  }

  onBack() {
    this.ok = true;
  }

  showDiv() {
    this.divId = 1;
  }


  onSterge1() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc1.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc1() {
    this.sterge1 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onSterge2() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc2.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc2() {
    this.sterge2 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onSterge3() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc3.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc3() {
    this.sterge3 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onSterge4() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc4.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc4() {
    this.sterge4 = true;
    this.del1 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onSterge5() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc5.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc5() {
    this.sterge5 = true;
    this.del2 = true;
    this.show = 1;
    this.dlg.hide();
  }

  onSterge6() {

    this.dlg = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc6.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc6() {
    this.sterge6 = true;
    this.del3 = true;
    this.show = 1;
    this.dlg.hide();
  }
}
