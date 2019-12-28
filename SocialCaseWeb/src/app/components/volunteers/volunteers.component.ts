import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-volunteers',
  templateUrl: './volunteers.component.html',
  styleUrls: ['./volunteers.component.css']
})
export class VolunteersComponent implements OnInit {

  nmb: number;
  ok: boolean;
  divId: number;
  display: boolean;

  constructor() { }

  ngOnInit() {
    this.ok = true;
    this.divId = 0;
    this.display = true;
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

}
