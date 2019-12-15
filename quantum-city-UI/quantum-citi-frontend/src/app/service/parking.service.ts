import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class ParkingService {

  constructor(private http: HttpClient) { }

  getParking(){
    return this.http.get(URL+"parking");
  }

}
