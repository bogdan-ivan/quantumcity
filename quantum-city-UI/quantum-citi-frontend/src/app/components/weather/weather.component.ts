import { Component, OnInit } from '@angular/core';
import { WeatherService } from 'src/app/service/weather.service';
import { Weather } from 'src/app/models/weather';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {

  weatherData : Weather[];

  constructor(
    public weatherService: WeatherService
  ) { }

  ngOnInit() {
    this.weatherService.getWeather().subscribe((response : Weather[])=> {
      this.weatherData = response;
      console.log(this.weatherData);
    })

  }

}
