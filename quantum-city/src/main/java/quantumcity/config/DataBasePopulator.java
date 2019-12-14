package quantumcity.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import quantumcity.persistance.entities.Parking;
import quantumcity.persistance.entities.Traffic;
import quantumcity.persistance.repos.ParkingRepository;
import quantumcity.persistance.repos.TrafficRepository;

@Configuration
public class DataBasePopulator {

	@Autowired
	ParkingRepository parkingRepository;
	
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
		}
	}
	
}
