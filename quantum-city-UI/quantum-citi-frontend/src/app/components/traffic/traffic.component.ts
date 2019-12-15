import { Component, OnInit, ViewChild } from '@angular/core';
import { Traffic } from 'src/app/models/traffic';
import { TrafficService } from 'src/app/service/traffic.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';


@Component({
  selector: 'app-traffic',
  templateUrl: './traffic.component.html',
  styleUrls: ['./traffic.component.scss']
})
export class TrafficComponent implements OnInit {

  traffic :Traffic[];

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  displayedColumns: string[] = ['id', 'name','state'];
  dataSource: MatTableDataSource<Traffic>;

  constructor(
    public trafficService: TrafficService
  ) {}

  ngOnInit() {
    this.trafficService.getTraffic().subscribe((response : Traffic[])=> {
      this.traffic = response;
      this.dataSource = new MatTableDataSource(this.traffic);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
  
  }

}
