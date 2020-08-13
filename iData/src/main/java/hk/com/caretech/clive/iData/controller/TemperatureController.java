package hk.com.caretech.clive.iData.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.model.Temperature;
import hk.com.caretech.clive.iData.repository.TemperatureRepository;

@RestController
public class TemperatureController {

	
	@Autowired
    private TemperatureRepository temperatureRepository;
	
	//private static SessionFactory sessionFactory = null;
	
	//@PersistenceContext
	//public EntityManager em;
	
	Logger logger = LoggerFactory.getLogger("TemperatureController");
	
	
//	//Return HTML page
//	@RequestMapping("/temp")
//	public String findAll(Model model){
//		//ModelAndView mav = new ModelAndView("elder");
//		List<Temperature> tempList = temperatureRepository.findAll();
//		//mav.addObject("elders", elderList);
//		model.addAttribute("temps", tempList);
//		return "temperature";
//	}
	

	@GetMapping("/temp")
	public Iterable<Temperature> findAll(){
		return temperatureRepository.findAll();	
	}
	
	
	@GetMapping("/temp/elder_id")
	public List<Temperature> getByElderId(@RequestParam String elder_id) {
		return temperatureRepository.getByElderId(elder_id);
	}
	
	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Temperature> addTemp(
			@RequestParam("dev_timestamp") String dev_timestamp,
			@RequestParam("elder_id") String elder_id,
			@RequestParam("temperature") double temperature,
			@RequestParam("timestamp") Timestamp timestamp,
			Temperature temp
			) {
		temp.setDev_timestamp(dev_timestamp);
		temp.setElder_ID(elder_id);
		temp.setTemperature(temperature);
		temp.setTimestamp(timestamp);
		temperatureRepository.save(temp);
	    return new ResponseEntity<Temperature>(temp, HttpStatus.CREATED);
	}
	
	@PutMapping("/temp/update")
	public Temperature update(@RequestBody Temperature temp){
		if(temperatureRepository.findById(temp.getElder_ID()).isPresent()){
			return temperatureRepository.save(temp);}
		 else {throw new RuntimeException("Elder ID not found");
	 }
	}
	
	
//	@DeleteMapping("/temp/delete/{tempid}")
//	 public void deleteById(@PathVariable String dev_timestamp) {
//	     temperatureRepository.deleteByDev_timestamp(dev_timestamp);
//		 }
}

