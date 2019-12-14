package quantumcity.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import quantumcity.persistance.entities.Parking;
import quantumcity.persistance.entities.Traffic;
import quantumcity.persistance.entities.Weather;
import quantumcity.persistance.repos.ParkingRepository;
import quantumcity.persistance.repos.TrafficRepository;
import quantumcity.persistance.repos.WeatherRepository;

@Configuration
public class DataBasePopulator {

	@Autowired
	ParkingRepository parkingRepository;
	
	@Autowired
	WeatherRepository weatherRepository;

	@Autowired
	TrafficRepository trafficRepository;
	
	@PostConstruct
	public void generateParkings() {
		if(parkingRepository.findAll().size() == 0) {
		List<Parking> parkings = new ArrayList<Parking>();
		parkings.add(new Parking("NORREPORT",65));
		parkings.add(new Parking("SKOLEBAKKEN",512));
		parkings.add(new Parking("SCANDCENTER",1240));
		parkings.add(new Parking("BRUUNS",953));
		parkings.add(new Parking("BUSGADEHUSET",130));
		parkings.add(new Parking("MAGASIN",400));
		parkings.add(new Parking("KALKVAERKSVEJ",210));
		parkings.add(new Parking("SALLING",700));
		
		for(Parking parking: parkings) {
			parkingRepository.save(parking);
		}
	}
	}
	
	@SuppressWarnings("resource")
	@PostConstruct
	public void generateWeather() throws FileNotFoundException {
		if(weatherRepository.findAll().size() == 0) {
			File file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\dewptm.txt");
			Scanner scan = new Scanner(file);
			String date, hour, value="";
			Integer cnt = 0;
			List<Weather> weather = new ArrayList<Weather>();
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				value = scan.next();
				weather.add(new Weather(date,hour,value));
			}
			
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\hum.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				value = scan.next();
				weather.get(cnt).setHum(value);
				cnt++;
			}
			
			cnt=0;
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\pressurem.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				if(scan.hasNext()) {
					value = scan.next();
					weather.get(cnt).setPressurem(value);
					}
					weather.get(cnt).setWspdm("-");
				cnt++;
			}
			
			cnt=0;
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\tempm.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				value = scan.next();
				weather.get(cnt).setTempm(value);
				cnt++;
			}
			
			cnt=0;
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\vism.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				value = scan.next();
				weather.get(cnt).setVisim(value);
				cnt++;
			}
			
			cnt=0;
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\wdird.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				hour = scan.next();
				if(scan.hasNext()) {
					value = scan.next();
					weather.get(cnt).setWdird(value);
					} else {
					weather.get(cnt).setWdird("-");
					}
				cnt++;
			}
			
			cnt=0;
			file = new File("C:\\Users\\HrihorRa\\Desktop\\Radu\\quantumcity\\quantum-city\\src\\main\\resources\\weather\\wspdm.txt");
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				date = scan.next();
				if(scan.hasNext()) {
					hour = scan.next();
				} else { hour=""; }
				if(scan.hasNext()) {
				value = scan.next();
				weather.get(cnt).setWspdm(value);
				} else {
				weather.get(cnt).setWspdm("-");
				}
				
				cnt++;
			}
			
			for(Weather w: weather) {
				this.weatherRepository.save(w);
			}
		}
	}
	
	
	@PostConstruct
	public void generateTraffic() {
		if(trafficRepository.findAll().size() == 0) {
			List<Traffic> traffics = new ArrayList<Traffic>();
			traffics.add(new Traffic(100,5,"13 Decembrie",2));
			traffics.add(new Traffic(10,8,"Bulevard Grivitei",1));
			traffics.add(new Traffic(20,17,"Cale Bucuresti",1));
			traffics.add(new Traffic(30,12,"Bulevard Saturn",0));
			traffics.add(new Traffic(40,16,"Alee Lacramioarelor",0));
			traffics.add(new Traffic(50,13,"Muresenilor",0));
			traffics.add(new Traffic(33,14,"Bulevard Garii",2));
			traffics.add(new Traffic(11,15,"Bulevard Victoriei",0));
			
			for(Traffic t: traffics) {
				this.trafficRepository.save(t);
			}
		}
	}
	
}
