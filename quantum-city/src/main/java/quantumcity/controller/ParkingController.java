package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping()
	public ResponseEntity<List<Parking>> getParkingss(){
		List<Parking> parkingList = null;
		try {
			parkingList = this.parkingRepository.findAll();
			return new ResponseEntity<List<Parking>>(parkingList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Parking>>(parkingList, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
