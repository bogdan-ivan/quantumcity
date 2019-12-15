package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quantumcity.persistance.entities.Traffic;
import quantumcity.persistance.repos.TrafficRepository;

@Controller
@RequestMapping("traffic")
@CrossOrigin(origins = { "*" })
public class TrafficController {

	@Autowired
	private TrafficRepository trafficRepository; 
	
	@GetMapping()
	public ResponseEntity<List<Traffic>> getTraffic(){
		List<Traffic> trafficList = null;
		try {
			trafficList = this.trafficRepository.findAll();
			return new ResponseEntity<List<Traffic>>(trafficList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Traffic>>(trafficList, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
