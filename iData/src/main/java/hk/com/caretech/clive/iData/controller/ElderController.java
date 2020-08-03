package hk.com.caretech.clive.iData.controller;


import java.util.List;

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

@RestController
public class ElderController {
	
	@Autowired
    private ElderRepository elderRepository;
	
	EntityManager entityManager;

//	EntityManager entityManager;

	
	Logger logger = LoggerFactory.getLogger("ElderController");
	
	
	@GetMapping("/")
	public String testConnect(){
		return "connected";	
	}
	
	@GetMapping("/elder")
	public List<Elder> findAll(){
		return elderRepository.findAll();
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
	public List<Elder> getElderById(@RequestParam String id) {
		return elderRepository.getById(id);
	}
	
	@GetMapping("/elder/name")
	public List<Elder> getElderByName(@RequestParam String name) {
		return elderRepository.getByName(name);
	}
	
	@GetMapping("/elder/bed_no")
	public List<Elder> getElderByBedNo(@RequestParam String bed_no) {
		return elderRepository.getByBedNo(bed_no);
	}
	
//	@PostMapping("/elder/add")
//	public void addElder(@RequestParam String name,@RequestParam int bed_no){
//		elderRepository.addElder(name, bed_no);
//		entityManager.createNativeQuery("insert into elder(name, bed_no) values (:name, :bed_no)")
//		.setParameter(1, elder.getName())
//		.setParameter(2, elder.getBed_no()).executeUpdate();
		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(elder.getId()).toUri();
		
		return ResponseEntity.created(path).build();*/

	
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

	
	
	
//	@PostMapping("/addelder")
//	public void addElder(@RequestParam String name,@RequestParam String bed_no){
//		elderRepository.addElder(name, bed_no);
////		entityManager.createNativeQuery("insert into elder(name, bed_no) values (:name, :bed_no)")
////		.setParameter(1, elder.getName())
////		.setParameter(2, elder.getBed_no()).executeUpdate();
//		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(elder.getId()).toUri();
//		
//		return ResponseEntity.created(path).build();*/
//	}
	

	
	
	@DeleteMapping("/elder/delete/{id}")
	public void deleteElder(@PathVariable int id) {
		elderRepository.deleteById(id);
	}
	
//	 @PutMapping("/elder/update/{userId}")
//	 public String updateUser(@PathVariable int userId, @RequestBody Elder elder){
//	
//	  
//	  return "HTTP PUT was called";
//	 }
	
	
	//=====for reference===
//	 @PutMapping("/employees/{id}")
//	    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//	 
//	        return repository.findById(id).map(employee -> {
//	            employee.setFirstName(newEmployee.getFirstName());
//	            employee.setLastName(newEmployee.getLastName());
//	            employee.setEmail(newEmployee.getEmail());
//	            return repository.save(employee);
//	        }).orElseGet(() -> {
//	            newEmployee.setId(id);
//	            return repository.save(newEmployee);
//	        });
//	    }
//	 
//	    @DeleteMapping("/employees/{id}")
//	    void deleteEmployee(@PathVariable Long id) {
//	        repository.deleteById(id);
//	    }

}
