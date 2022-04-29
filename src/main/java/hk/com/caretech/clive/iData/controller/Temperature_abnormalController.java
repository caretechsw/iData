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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.impl.TextTrieMap;

import hk.com.caretech.clive.iData.Utils;
import hk.com.caretech.clive.iData.model.Temperature;
import hk.com.caretech.clive.iData.model.Temperature_abnormal;
import hk.com.caretech.clive.iData.repository.Temperature_abnormalRepository;

@Controller
public class Temperature_abnormalController {

	
	@Autowired
    private Temperature_abnormalRepository temperature_abRepository;
	
	
	Logger logger = LoggerFactory.getLogger("Temperature_abnormalController");
	
	
	@GetMapping("/tempab_web")
	public String findAll_web(Model model){
		Iterable<Temperature_abnormal> tempabList = temperature_abRepository.findAll();
		model.addAttribute("tempabs" , tempabList);
		return "temperature_ab";
		}
	
	
	@GetMapping("/tempab_web/elderid")
	public ModelAndView getTempabByElderId_web(@RequestParam int elder_id) {
		Iterable<Temperature_abnormal> tempabList = temperature_abRepository.getByElderId(elder_id);
		return new ModelAndView("temperature_ab", "tempabs" , tempabList);
	}
	
	
	@GetMapping("/tempab_web/delete")
	public String deleteTempab_web(@RequestParam("dev_timestamp") String dev_timestamp){
		Temperature_abnormal tempab = temperature_abRepository.findById(dev_timestamp)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + dev_timestamp));
		tempab.setStatus_delete(Utils.deleted);
	    temperature_abRepository.save(tempab);
    return "redirect:/tempab_web";
    }
	
	
	//*****************************************************//

	@GetMapping("/tempab")
	@ResponseBody
	public Iterable<Temperature_abnormal> findAll(){
		return temperature_abRepository.findAll();	
	}
	
	
	@GetMapping("/tempab/elder_id")
	@ResponseBody
	public List<Temperature_abnormal> getByElderId(@RequestParam int elder_id) {
		return temperature_abRepository.getByElderId(elder_id);
	}
	
	@GetMapping("/tempab/dev_timestamp")
	@ResponseBody
	public Temperature_abnormal getByDev_timestamp(@RequestParam String dev_timestamp) {
		return temperature_abRepository.getByDev_timestamp(dev_timestamp);
	}
	
	@PostMapping(path = "/tempab/add",  consumes = {"application/x-www-form-urlencoded", 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Temperature_abnormal> addTempab(
			@RequestParam("dev_timestamp") String dev_timestamp,
			@RequestParam("elder_id") int elder_id,
			@RequestParam("temperature") float temperature,
			@RequestParam("timestamp") Timestamp timestamp,
			@RequestParam("device_id") String device_id,
			Temperature_abnormal tempab
			) {
		tempab.setDev_timestamp(dev_timestamp);
		tempab.setElder_id(elder_id);
		tempab.setTemperature(temperature);
		tempab.setTimestamp(timestamp);
		tempab.setDevice_id(device_id);
		tempab.setStatus_delete(Utils.nonDeleted);
		temperature_abRepository.save(tempab);
	    return new ResponseEntity<Temperature_abnormal>(tempab, HttpStatus.CREATED);
	}
	
	//update should not be used possibly
//	@PutMapping("/tempab/update")
//	public Temperature_abnormal update(@RequestBody Temperature_abnormal tempab){
//		if(temperature_abRepository.findById(tempab.getDev_timestamp()).isPresent()){
//			tempab.setStatus_delete(Utils.nonDeleted);
//			return temperature_abRepository.save(tempab);}
//		 else {throw new RuntimeException("Elder ID not found");
//	 }
//	}
	
	
	public static String TAG = Temperature_abnormalController.class.getName();
}

