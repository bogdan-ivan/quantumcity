import { Component, OnInit } from '@angular/core';
import { Traffic } from 'src/app/models/traffic';
import { TrafficService } from 'src/app/service/traffic.service';

declare const getCarCounter : any;

@Component({
  selector: 'app-traffic',
  templateUrl: './traffic.component.html',
  styleUrls: ['./traffic.component.scss']
})
export class TrafficComponent implements OnInit {

  traffic :Traffic[];

  constructor(
    public trafficService: TrafficService
  ) { }

  ngOnInit() {
    this.trafficService.getTraffic().subscribe((response : Traffic[])=> {
      this.traffic = response;
    })
    console.log(this.traffic);
  }

}
