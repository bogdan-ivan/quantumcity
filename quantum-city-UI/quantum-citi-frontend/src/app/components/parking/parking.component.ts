import { Component, OnInit, ViewChild } from '@angular/core';
import { ParkingService } from 'src/app/service/parking.service';
import { Parking } from 'src/app/models/parking';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { PollutionService } from 'src/app/service/pollution.service';
import { Pollution } from 'src/app/models/pollution';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.scss']
})
export class ParkingComponent implements OnInit {

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  parkings : Parking[];
  states : Boolean[];

  displayedColumns: string[] = ['name', 'free','busy'];
  dataSource: MatTableDataSource<Parking>;

  constructor(
    public parkingService : ParkingService
  ) {}

  ngOnInit() {
    this.parkingService. getParking().subscribe((response: Parking[])=> {
      this.parkings = response;
      this.dataSource = new MatTableDataSource(this.parkings);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      });
  }

}
