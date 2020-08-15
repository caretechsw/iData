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

import hk.com.caretech.clive.iData.model.Temperature_abnormal;
import hk.com.caretech.clive.iData.repository.Temperature_abnormalRepository;

@RestController
public class Temperature_abnormalController {

	
	@Autowired
    private Temperature_abnormalRepository temperature_abnormalRepository;
	
	//private static SessionFactory sessionFactory = null;
	
	//@PersistenceContext
	//public EntityManager em;
	
	Logger logger = LoggerFactory.getLogger("Temperature_abnormalController");
	
	
//	//Return HTML page
//	@RequestMapping("/temp_adnormal")
//	public String findAll(Model model){
//		//ModelAndView mav = new ModelAndView("elder");
//		List<Temperature_adnormal> temp_abnormalList = temperature_abnormalRepository.findAll();
//		//mav.addObject("elders", elderList);
//		model.addAttribute("temps_abnormal", tempList);
//		return "temperature";
//	}
	

	@GetMapping("/temp_abnormal")
	public Iterable<Temperature_abnormal> findAll(){
		return temperature_abnormalRepository.findAll();	
	}
	
	
	@GetMapping("/temp_abnormal/elder_id")
	public List<Temperature_abnormal> getByElderId(@RequestParam int elder_id) {
		return temperature_abnormalRepository.getByElderId(elder_id);
	}
	
	@GetMapping("/temp_abnormal/dev_timestamp")
	public List<Temperature_abnormal> getByDev_timestamp(@RequestParam String dev_timestamp) {
		return temperature_abnormalRepository.getByDev_timestamp(dev_timestamp);
	}
	
	@PostMapping(path = "/temp_abnormal/add",  consumes = {"application/x-www-form-urlencoded", 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Temperature_abnormal> addTemp(
			@RequestParam("dev_timestamp") String dev_timestamp,
			@RequestParam("elder_id") int elder_id,
			@RequestParam("temperature") double temperature,
			@RequestParam("timestamp") Timestamp timestamp,
			@RequestParam("device_id") String device_id,
			Temperature_abnormal temp_abnormal
			) {
		temp_abnormal.setDev_timestamp(dev_timestamp);
		temp_abnormal.setElder_id(elder_id);
		temp_abnormal.setTemperature(temperature);
		temp_abnormal.setTimestamp(timestamp);
		temp_abnormal.setDevice_id(device_id);
		temperature_abnormalRepository.save(temp_abnormal);
	    return new ResponseEntity<Temperature_abnormal>(temp_abnormal, HttpStatus.CREATED);
	}
	
	@PutMapping("/temp_abnormal/update")
	public Temperature_abnormal update(@RequestBody Temperature_abnormal temp_abnormal){
		if(temperature_abnormalRepository.findById(temp_abnormal.getDev_timestamp()).isPresent()){
			return temperature_abnormalRepository.save(temp_abnormal);}
		 else {throw new RuntimeException("Elder ID not found");
	 }
	}
	
	
//	@DeleteMapping("/temp/delete/{tempid}")
//	 public void deleteById(@PathVariable String dev_timestamp) {
//	     temperatureRepository.deleteByDev_timestamp(dev_timestamp);
//		 }
}

