import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrafficComponent } from './components/traffic/traffic.component';
import { PollutionComponent } from './components/pollution/pollution.component';
import { ParkingComponent } from './components/parking/parking.component';
import { WeatherComponent } from './components/weather/weather.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    TrafficComponent,
    PollutionComponent,
    ParkingComponent,
    WeatherComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
