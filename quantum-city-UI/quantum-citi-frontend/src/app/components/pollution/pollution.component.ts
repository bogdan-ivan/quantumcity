import { Component, OnInit } from '@angular/core';
import { PollutionService } from 'src/app/service/pollution.service';
import { Pollution } from 'src/app/models/pollution';

@Component({
  selector: 'app-pollution',
  templateUrl: './pollution.component.html',
  styleUrls: ['./pollution.component.scss']
})
export class PollutionComponent implements OnInit {

pollution : Pollution[];

  constructor(
    public pollutionService : PollutionService
  ) { }

  ngOnInit() {
    this.pollutionService. getPollution().subscribe((response: Pollution[])=> {
      this.pollution = response;
    })
    console.log(this.pollution);
  }

}
