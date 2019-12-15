import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class PollutionService {

  constructor(private http: HttpClient) { }

  getPollution(){
    return this.http.get(URL+"pollution");
  }

}
