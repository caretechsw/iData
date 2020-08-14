package hk.com.caretech.clive.iData.controller;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.Session;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.repository.ElderRepository;
import net.bytebuddy.asm.Advice.Return;

@RestController
public class ElderController {
	
	@Autowired
    private ElderRepository elderRepository;
	

	Logger logger = LoggerFactory.getLogger("ElderController");
	
	
	@GetMapping("/")
	public String testConnect(){
		return "connected";	
	}
	
	@GetMapping("/elder")
	public Iterable<Elder> findAll(){
		return elderRepository.findAll();
	//	return elderRepository.findAll();
		}
	
//	//Return HTML page
//	@RequestMapping("/elder")
//	public String findAll(Model model){
//		//ModelAndView mav = new ModelAndView("elder");
//		List<Elder> elderList = elderRepository.findAll();
//		//mav.addObject("elders", elderList);
//		model.addAttribute("elders", elderList);
//		return "elder";
//	}
	
	@GetMapping("/elder/id")
	public List<Elder> getElderById(@RequestParam int id) {
		return elderRepository.getById(id);
	}
	
	@GetMapping("/elder/name")
	public List<Elder> getElderByName(@RequestParam String name) {
		return elderRepository.getByName(name);
	}
	
	@GetMapping("/elder/bed_no")
	public List<Elder> getElderByBedNo(@RequestParam int bed_no) {
		return elderRepository.getByBedNo(bed_no);
	}
	

	//Product Json format object
	@PostMapping("/elder/add")
	public void addElderBody(@RequestBody Elder elder) {
	elderRepository.save(elder);
	}
	
	//For the use of Okhttp api from android
	@PostMapping(path = "/elder/add",  consumes = "application/x-www-form-urlencoded")
	public void addElder(Elder elder) {
	elderRepository.save(elder);
	}

	@PutMapping("/elder/update")
	public Elder updateUser(@RequestBody Elder elder){
		if(elderRepository.findById(elder.getId()).isPresent()){
			return elderRepository.save(elder);}
		 else {throw new RuntimeException("Elder ID not found");
	 }
	}
	
	@DeleteMapping("/elder/delete/{id}")
	 public void deleteById(@PathVariable int id) {
		elderRepository.deleteById(id);
		}
}
