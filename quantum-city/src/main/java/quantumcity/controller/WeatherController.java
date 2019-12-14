package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quantumcity.persistance.entities.Weather;
import quantumcity.persistance.repos.WeatherRepository;

@Controller
@RequestMapping("weather")
@CrossOrigin(origins = { "*" })
public class WeatherController {

	@Autowired
	private WeatherRepository weatherRepository; 
	
	@GetMapping
	public List<Weather> getweathers(){
		return this.weatherRepository.findAll();
	}
	
}
