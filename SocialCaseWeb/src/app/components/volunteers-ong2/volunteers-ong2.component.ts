import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {FormularInterface} from '../formular/formular.component';

@Component({
  selector: 'app-volunteers-ong2',
  templateUrl: './volunteers-ong2.component.html',
  styleUrls: ['./volunteers-ong2.component.css']
})
export class VolunteersOng2Component implements OnInit {


  nmb: number;
  ok: boolean;
  divId: number;
  display: boolean;
  voluntar: number;

  constructor(private route: ActivatedRoute, private ong: FormularInterface) { }

  ngOnInit() {
    this.ok = true;
    this.divId = 0;
    this.display = true;
    this.ong.id = '2';
    this.voluntar = 5;
  }

  openDetails(nr: number) {
    this.ok = false;
    this.nmb = nr;
  }

  onBack() {
    this.ok = true;
  }

  setShow() {
    this.display = false;
  }

  showDiv(id) {
    this.divId = id;
  }

  showCalin() {
    this.voluntar = 1;
  }


}
