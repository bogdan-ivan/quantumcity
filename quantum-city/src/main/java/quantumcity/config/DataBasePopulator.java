package quantumcity.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import quantumcity.persistance.entities.Parking;
import quantumcity.persistance.repos.ParkingRepository;

@Configuration
public class DataBasePopulator {

	@Autowired
	ParkingRepository parkingRepository;
	
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
	
}
