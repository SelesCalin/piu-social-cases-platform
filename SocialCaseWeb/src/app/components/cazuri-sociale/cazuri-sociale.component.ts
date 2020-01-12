import {Component, EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import { DialogUtility } from '@syncfusion/ej2-popups';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class CasesInterface {
  id: string;
}

@Component({
  selector: 'app-cazuri-sociale',
  templateUrl: './cazuri-sociale.component.html',
  styleUrls: ['./cazuri-sociale.component.css']
})
export class CazuriSocialeComponent implements OnInit {

  private dlg;
  message: string;
  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router,
              private ongId: CasesInterface) {}

  refuzat1: boolean;
  refuzat2: boolean;
  refuzat3: boolean;

  ok1: number;
  nmb1: number;
  display: boolean;
  divId: number;
  open: boolean;

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

  planOk: boolean;

  enableEdit1: boolean;
  enableEditIndex1 = null;

  enableEdit2: boolean;
  enableEditIndex2 = null;

  enableEdit3: boolean;
  enableEditIndex3 = null;

  enableEdit4: boolean;
  enableEditIndex4 = null;

  enableEdit5: boolean;
  enableEditIndex5 = null;

  enableEdit6: boolean;
  backendData1 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: 'Nurofen Express Forte, Vitamina C',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: 'Magneziu cu D3 si Calciu, Vitamina B, Picaturi in ochi',
      v3: '',
      v4: '',
      v5: 'Diclofenac',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: 'Nurofen Express Forte, Vitamina C, Magneziu',
      v2: '',
      v3: 'Metoclopramid',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData2 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: 'Paduden',
      v3: 'Nurofen Forte, Vitamin C',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData3 = [{
    v0: '08:00 - 10:00',
    v1: 'Algocalmin',
    v2: '',
    v3: 'Nalgesin, Fiobilin',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData4 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData5 = [{
    v0: '08:00 - 10:00',
    v1: 'Vitamin C, Colebil',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: 'Paracetamol',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: 'Fervex',
      v2: '',
      v3: 'Vitamina C, Faringosept',
      v4: '',
      v5: 'Propolis',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: 'Aspacardin',
      v3: '',
      v4: 'Eutirox',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData6 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: 'Nalgesin, Paracetamol',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: 'Nurofen Forte',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: 'Algocalmin, Fiobilin',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  /////////////////////////////////////////////// V2 ///////////////////////////////////////////////////////////
  ok12: number;
  nmb12: number;
  display2: boolean;
  divId2: number;
  open2: boolean;

  ok2: boolean;
  nmb2: number;
  show2: number;

  sterge12: boolean;
  sterge22: boolean;
  sterge32: boolean;
  sterge42: boolean;
  sterge52: boolean;
  sterge62: boolean;
  sterge72: boolean;
  sterge82: boolean;
  sterge92: boolean;

  del12: boolean;
  del22: boolean;
  del32: boolean;
  del42: boolean;
  del52: boolean;
  del62: boolean;

  refuz12: boolean;
  refuz22: boolean;
  refuz32: boolean;
  refuz42: boolean;
  refuz52: boolean;
  refuz62: boolean;

  accept12: boolean;
  accept112: boolean;
  accept22: boolean;
  accept32: boolean;
  accept42: boolean;
  accept52: boolean;
  accept62: boolean;

  fillData12: boolean;
  fillData22: boolean;
  fillData32: boolean;
  fillData42: boolean;
  planOk2: boolean;

  enableEdit12: boolean;
  enableEditIndex12 = null;

  enableEdit22: boolean;
  enableEditIndex22 = null;

  enableEdit32: boolean;
  enableEditIndex32 = null;

  enableEdit42: boolean;
  enableEditIndex42 = null;

  enableEdit52: boolean;
  enableEditIndex52 = null;

  enableEdit62: boolean;
  enableEditIndex62 = null;

  backendData12 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: 'Diclofenac',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: 'Nurofen Express Forte, Vitamina C, Magneziu',
      v2: '',
      v3: 'Metoclopramid',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData22 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: 'Paduden',
      v3: 'Nurofen Forte, Vitamin C',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData32 = [{
    v0: '08:00 - 10:00',
    v1: 'Algocalmin',
    v2: '',
    v3: 'Nalgesin, Fiobilin',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData42 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData52 = [{
    v0: '08:00 - 10:00',
    v1: 'Vitamin C, Colebil',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: '',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: '',
      v2: '',
      v3: 'Paracetamol',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: 'Fervex',
      v2: '',
      v3: 'Vitamina C, Faringosept',
      v4: '',
      v5: 'Propolis',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: 'Aspacardin',
      v3: '',
      v4: 'Eutirox',
      v5: '',
      v6: '',
      v7: ''
    }];

  backendData62 = [{
    v0: '08:00 - 10:00',
    v1: '',
    v2: '',
    v3: '',
    v4: '',
    v5: '',
    v6: 'Nalgesin, Paracetamol',
    v7: ''
  },
    {
      v0: '12:00 - 14:00',
      v1: 'Nurofen Forte',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '18:00 - 20:00',
      v1: '',
      v2: '',
      v3: '',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    },
    {
      v0: '22:00 - 00:00',
      v1: '',
      v2: '',
      v3: 'Algocalmin, Fiobilin',
      v4: '',
      v5: '',
      v6: '',
      v7: ''
    }];

  private dlg2;

  ngOnInit() {
    this.ongId.id = this.route.snapshot.paramMap.get('id');
    this.ok1 = 1;

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

    this.planOk = true;
    this.open = false;

    this.ok12 = 1;

    this.ok2 = true;
    this.show2 = 1;
    this.divId2 = 1;

    this.del12 = false;
    this.del22 = false;
    this.del32 = false;
    this.del42 = false;
    this.del52 = false;
    this.del62 = false;

    this.sterge12 = false;
    this.sterge22 = false;
    this.sterge32 = false;
    this.sterge42 = false;
    this.sterge52 = false;
    this.sterge62 = false;
    this.sterge72 = false;
    this.sterge82 = false;
    this.sterge92 = false;

    this.refuz12 = false;
    this.refuz22 = false;
    this.refuz32 = false;
    this.refuz42 = false;
    this.refuz52 = false;
    this.refuz62 = false;

    this.accept12 = true;
    this.accept112 = false;
    this.accept22 = true;
    this.accept32 = true;
    this.accept42 = true;
    this.accept52 = true;
    this.accept62 = true;

    this.planOk2 = true;
    this.open2 = false;
  }

  openDetails1(nr: number) {
    this.ok1 = 0;
    this.nmb1 = nr;
  }

  onBack1() {
    this.ok1 = 1;
  }

  setShow() {
    this.display = false;
    this.divId = 0;
    this.ok1 = 0;
  }

  setShow2() {
    this.display = true;
    this.divId = 0;
    this.ok1 = 1;
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
    this.refuzat1 = false;

  }

  refuzFunc1() {
    this.refuz1 = true;
    this.show = 1;
    this.dlg.hide();
    this.refuzat1 = false;
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
    this.refuzat2 = false;
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
    this.refuzat3 = false;
  }

  onAccept1() {
    this.accept1 = false;
    this.show = 1;
    this.accept11 = true;
    this.fillData1 = true;
  }

  onAccept2() {
    this.refuz2 = true;
    this.show = 1;
    this.fillData2 = true;
    this.onFuncAccept();
  }

  onFuncAccept() {

    this.dlg = DialogUtility.alert({
      content: 'Cazul a fost acceptat!',
      okButton: {
        text: 'OK'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
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

  openPlan(num: number)  {
    this.nmb1 = num;
    this.ok1 = 2;
  }

  enableEditMethod1(e, i) {
    this.enableEdit1 = true;
    this.enableEditIndex1 = i;
    console.log(e);
  }

  save1() {
    this.enableEditIndex1 = null;
  }

  enableEditMethod2(e, i) {
    this.enableEdit2 = true;
    this.enableEditIndex2 = i;
    console.log(e);
  }

  save2() {
    this.enableEditIndex2 = null;
  }

  enableEditMethod3(e, i) {
    this.enableEdit3 = true;
    this.enableEditIndex3 = i;
    console.log(e);
  }

  save3() {
    this.enableEditIndex3 = null;
  }

  enableEditMethod4(e, i) {
    this.enableEdit4 = true;
    this.enableEditIndex4 = i;
    console.log(e);
  }

  save4() {
    this.enableEditIndex4 = null;
  }

  enableEditMethod5(e, i) {
    this.enableEdit5 = true;
    this.enableEditIndex5 = i;
    console.log(e);
  }

  save5() {
    this.enableEditIndex5 = null;
  }

  openDetails12(nr: number) {
    this.ok12 = 0;
    this.nmb12 = nr;
  }

  onBack12() {
    this.ok12 = 1;
  }

  setShoww() {
    this.display2 = false;
    this.divId2 = 0;
    this.ok12 = 0;
    this.refuzat1 = this.refuzat1 !== true;
  }

  setShoww2() {
    this.display2 = true;
    this.divId2 = 0;
    this.ok12 = 1;
    this.refuzat1 = true;
  }

  onRefuz12() {

    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc12.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc12() {
    this.refuz12 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onRefuz22() {

    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc22.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc22() {
    this.refuz22 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onRefuz32() {

    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc32.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });

  }

  refuzFunc32() {
    this.refuz32 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onRefuz42() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.refuzFunc42.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  refuzFunc42() {
    this.refuz42 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onAccept12() {
    this.fillData12 = true;
    this.refuz12 = true;
    this.show2 = 1;
    this.onFuncAccept();
  }

  onAccept22() {
    this.fillData22 = true;
    this.refuz22 = true;
    this.show2 = 1;
  }

  onAccept32() {
    this.fillData32 = true;
    this.refuz32 = true;
    this.show2 = 1;
  }

  onAccept42() {
      this.fillData42 = true;
      this.refuz42 = true;
      this.show2 = 1;
      this.onFuncAccept();
  }

  openDetails2(nr: number) {
    this.ok2 = false;
    this.nmb2 = nr;
  }

  onBack2() {
    this.ok2 = true;
  }

  showDiv2() {
    this.divId2 = 1;
  }

  onSterge12() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc12.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc12() {
    this.sterge12 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge22() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc22.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc22() {
    this.sterge22 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge32() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc32.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc32() {
    this.sterge32 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge42() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc42.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc42() {
    this.sterge42 = true;
    this.del12 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge52() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc52.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc52() {
    this.sterge52 = true;
    this.del22 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge62() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc62.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc62() {
    this.sterge62 = true;
    this.del32 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  onSterge72() {
    this.dlg2 = DialogUtility.confirm({
      title: 'Atentie!',
      content: 'Cazul va fi eliminat definitiv din lista! Sunteti sigur ca aceasta doriti?',
      okButton: {
        text: 'Da', click: this.stergeFunc72.bind(this)},
      cancelButton: {text: 'Nu'},
      showCloseIcon: true,
      closeOnEscape: true,
      animationSettings: { effect: 'Zoom' },
    });
  }

  stergeFunc72() {
    this.sterge72 = true;
    this.del42 = true;
    this.show2 = 1;
    this.dlg2.hide();
  }

  openPlan2(num: number)  {
    this.nmb12 = num;
    this.ok12 = 2;
  }

  enableEditMethod12(e, i) {
    this.enableEdit12 = true;
    this.enableEditIndex12 = i;
    console.log(e);
  }

  save12() {
    this.enableEditIndex12 = null;
  }

  enableEditMethod22(e, i) {
    this.enableEdit22 = true;
    this.enableEditIndex22 = i;
    console.log(e);
  }

  save22() {
    this.enableEditIndex22 = null;
  }

  enableEditMethod32(e, i) {
    this.enableEdit32 = true;
    this.enableEditIndex32 = i;
    console.log(e);
  }

  save32() {
    this.enableEditIndex32 = null;
  }

  enableEditMethod42(e, i) {
    this.enableEdit42 = true;
    this.enableEditIndex42 = i;
    console.log(e);
  }

  save42() {
    this.enableEditIndex42 = null;
  }

  enableEditMethod52(e, i) {
    this.enableEdit52 = true;
    this.enableEditIndex52 = i;
    console.log(e);
  }

  save52() {
    this.enableEditIndex52 = null;
  }

  enableEditMethod62(e, i) {
    this.enableEdit62 = true;
    this.enableEditIndex62 = i;
    console.log(e);
  }

  save62() {
    this.enableEditIndex62 = null;
  }

}
