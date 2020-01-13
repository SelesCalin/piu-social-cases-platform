import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {FormularInterface} from '../formular/formular.component';

@Component({
  selector: 'app-home-ong2',
  templateUrl: './home-ong2.component.html',
  styleUrls: ['./home-ong2.component.css']
})
export class HomeOng2Component implements OnInit {

  display: boolean;
  divId: number;

  constructor(private route: ActivatedRoute, private ong: FormularInterface) { }

  ngOnInit() {
    this.display = true;
    this.divId = 0;
    this.ong.id = '2';
  }

  setShow() {
    this.display = false;
  }

  showDiv(id) {
    this.divId = id;
  }
}


