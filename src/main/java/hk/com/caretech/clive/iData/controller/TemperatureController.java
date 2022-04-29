package hk.com.caretech.clive.iData.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.hibernate.internal.util.streams.StingArrayCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hk.com.caretech.clive.iData.Utils;
import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.model.Temperature;
import hk.com.caretech.clive.iData.model.Temperature_abnormal;
import hk.com.caretech.clive.iData.repository.TemperatureRepository;

@Controller
public class TemperatureController {
	
	@Autowired
    private TemperatureRepository temperatureRepository;
	
	
	Logger logger = LoggerFactory.getLogger("TemperatureController");
	
	@GetMapping("/temp_web")
	public String findAll_web(Model model){
		Iterable<Temperature> tempList = temperatureRepository.findAll();
		model.addAttribute("temps" , tempList);
		return "temperature";
		}
	
	
	@GetMapping("/temp_web/elderid")
	public ModelAndView getTempByElderId_web(@RequestParam int elder_id) {
		Iterable<Temperature> tempList = temperatureRepository.getByElderId(elder_id);
		return new ModelAndView("temperature", "temps" , tempList);
	}
	
	@GetMapping("/temp_web/delete")
	public String deleteTemp_web(@RequestParam("dev_timestamp") String dev_timestamp){
		Temperature temp = temperatureRepository.findById(dev_timestamp)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + dev_timestamp));
		temp.setStatus_delete(Utils.deleted);
	    temperatureRepository.save(temp);	
    return "redirect:/temp_web";
    }
	
	
	//********************************************************//
	
	

	@GetMapping("/temp")
	@ResponseBody
	public Iterable<Temperature> findAll(){
		return temperatureRepository.findAll();	
	}
	
	
	@GetMapping("/temp/elder_id")
	@ResponseBody
	public List<Temperature> getByElderId(@RequestParam int elder_id) {
		return temperatureRepository.getByElderId(elder_id);
	}
	
	@GetMapping("/temp/dev_timestamp")
	@ResponseBody
	public Temperature getByDev_timestamp(@RequestParam String dev_timestamp) {
		return temperatureRepository.getByDev_timestamp(dev_timestamp);
	}
	
	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Temperature> addTemp(
			@RequestParam("dev_timestamp") String dev_timestamp,
			@RequestParam("elder_id") int elder_id,
			@RequestParam("temperature") float temperature,
			@RequestParam("timestamp") Timestamp timestamp,
			@RequestParam("device_id") String device_id,
			Temperature temp
			) {
		temp.setDev_timestamp(dev_timestamp);
		temp.setElder_id(elder_id);
		temp.setTemperature(temperature);
		temp.setTimestamp(timestamp);
		temp.setDevice_id(device_id);
		temp.setStatus_delete(Utils.nonDeleted);
		temperatureRepository.save(temp);
	    return new ResponseEntity<Temperature>(temp, HttpStatus.CREATED);
	}
	
// update should not be used possibly
//	@PutMapping("/temp/update")
//	public Temperature update(@RequestBody Temperature temp){
//		if(temperatureRepository.findById(temp.getDev_timestamp()).isPresent()){
//			temp.setStatus_delete(Utils.nonDeleted);
//			return temperatureRepository.save(temp);}
//		 else {throw new RuntimeException("Elder ID not found");
//	 }
//	}
	
	public static String TAG = TemperatureController.class.getName();
}

