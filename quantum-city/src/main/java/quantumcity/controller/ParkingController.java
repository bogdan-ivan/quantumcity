package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quantumcity.persistance.entities.Parking;
import quantumcity.persistance.repos.ParkingRepository;

@Controller
@RequestMapping("parking")
@CrossOrigin(origins = { "*" })
public class ParkingController {

	@Autowired
	private ParkingRepository parkingRepository; 
	
	@GetMapping
	public List<Parking> getParkings(){
		return this.parkingRepository.findAll();
	}
	
}
