import { Component, OnInit } from '@angular/core';

declare const getCarCounter : any;

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  onClick() {
    console.log(getCarCounter());
  }

}
