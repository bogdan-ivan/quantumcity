import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pollution',
  templateUrl: './pollution.component.html',
  styleUrls: ['./pollution.component.scss']
})
export class PollutionComponent implements OnInit {

  color = 'primary';
  mode = 'determinate';
  value = 50;
  bufferValue = 75;

  constructor() { }

  ngOnInit() {
  }

}
