import { Component, OnInit } from '@angular/core';
import { ParkingService } from 'src/app/service/parking.service';
import { Parking } from 'src/app/models/parking';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.scss']
})
export class ParkingComponent implements OnInit {

  parkings : Parking[]

  constructor(
    public parkingService: ParkingService
  ) { }

  ngOnInit() {
    this.parkingService.getParking().subscribe((response : Parking[]) => {
      this.parkings = response;
      console.log(this.parkings);
    });
  
  }

}
