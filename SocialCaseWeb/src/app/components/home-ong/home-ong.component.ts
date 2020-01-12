import { Component, OnInit } from '@angular/core';
import {FormularInterface} from '../formular/formular.component';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-home-ong',
  templateUrl: './home-ong.component.html',
  styleUrls: ['./home-ong.component.css']
})
export class HomeOngComponent implements OnInit {

  display: boolean;
  divId: number;

  constructor(private route: ActivatedRoute,  private ong: FormularInterface) { }

  ngOnInit() {
    // this.ong.id = this.route.snapshot.paramMap.get('id');
    this.display = true;
    this.divId = 0;
    this.ong.id = '1';
  }

  setShow() {
    this.display = false;
  }

  showDiv(id) {
    this.divId = id;
  }
}
