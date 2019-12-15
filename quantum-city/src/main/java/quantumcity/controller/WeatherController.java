package quantumcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/getWeather")
	public ResponseEntity<List<Weather>> getWeathers(){
		List<Weather> weatherList = null;
		try {
			weatherList = this.weatherRepository.findAll();
			return new ResponseEntity<List<Weather>>(weatherList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Weather>>(weatherList, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
