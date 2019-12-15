import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ParkingComponent } from './components/parking/parking.component';
import { PollutionComponent } from './components/pollution/pollution.component';
import { TrafficComponent } from './components/traffic/traffic.component';
import { WeatherComponent } from './components/weather/weather.component';


const routes: Routes = [
  {path : '', redirectTo : '/home', pathMatch : 'full'},
  {path : 'home', component : HomePageComponent},
  {path : 'parking', component: ParkingComponent},
  {path : 'pollution', component: PollutionComponent},
  {path : 'traffic', component: TrafficComponent},
  {path : 'weather', component: WeatherComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
