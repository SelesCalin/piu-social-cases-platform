import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-ong',
  templateUrl: './home-ong.component.html',
  styleUrls: ['./home-ong.component.css']
})
export class HomeOngComponent implements OnInit {

  display: boolean;
  divId: number;

  constructor() { }

  ngOnInit() {
    this.display = true;
    this.divId = 0;
  }

  setShow() {
    this.display = false;
  }

  showDiv(id) {
    this.divId = id;
  }
}
