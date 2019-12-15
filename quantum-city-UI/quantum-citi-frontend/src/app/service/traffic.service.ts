import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class TrafficService {

  constructor(private http: HttpClient) { }

  getTraffic(){
    return this.http.get(URL+"traffic");
  }

}
