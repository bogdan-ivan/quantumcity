import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  getWeather(){
    return this.http.get(URL+"weather/getWeather");
  }

}
