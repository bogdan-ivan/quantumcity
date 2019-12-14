package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping
	public List<Pollution> getPollution(){
		return this.pollutionRepository.findAll();
	}
	
}
