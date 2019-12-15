package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quantumcity.persistance.entities.Pollution;

import quantumcity.persistance.repos.PollutionRepository;

@Controller
@RequestMapping("pollution")
@CrossOrigin(origins = { "*" })
public class PollutionController {

	@Autowired
	private PollutionRepository pollutionRepository; 
	
	@GetMapping()
	public ResponseEntity<List<Pollution>> getPollution(){
		List<Pollution> pollutionList = null;
		try {
			pollutionList = this.pollutionRepository.findAll();
			return new ResponseEntity<List<Pollution>>(pollutionList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Pollution>>(pollutionList, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
