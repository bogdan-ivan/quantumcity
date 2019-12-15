import { Component, OnInit } from '@angular/core';

declare const getCarCounter : any;

@Component({
  selector: 'app-traffic',
  templateUrl: './traffic.component.html',
  styleUrls: ['./traffic.component.scss']
})
export class TrafficComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  onClick(){
    console.log("Nr. masini: ",getCarCounter());
  }

}
