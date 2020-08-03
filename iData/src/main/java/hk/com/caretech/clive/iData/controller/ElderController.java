package hk.com.caretech.clive.iData.controller;


import java.util.List;

<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
=======

>>>>>>> refs/remotes/origin/brand1

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> refs/remotes/origin/brand1
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
	
<<<<<<< HEAD
	EntityManager entityManager;
=======
//	EntityManager entityManager;
>>>>>>> refs/remotes/origin/brand1
	
	Logger logger = LoggerFactory.getLogger("ElderController");
	
	
	@GetMapping("/")
	public String testConnect(){
		return "connected";	
	}
	
	@GetMapping("/elder")
	public List<Elder> findAll(){
		return elderRepository.findAll();	
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/origin/brand1
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
<<<<<<< HEAD
		return elderRepository.getElderByBedNo(bed_no);
=======
		return elderRepository.getByBedNo(bed_no);
>>>>>>> refs/remotes/origin/brand1
	}
	
<<<<<<< HEAD
	@PostMapping("/elder/add")
	public void addElder(@RequestParam String name,@RequestParam int bed_no){
		elderRepository.addElder(name, bed_no);
//		entityManager.createNativeQuery("insert into elder(name, bed_no) values (:name, :bed_no)")
//		.setParameter(1, elder.getName())
//		.setParameter(2, elder.getBed_no()).executeUpdate();
		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(elder.getId()).toUri();
		
		return ResponseEntity.created(path).build();*/
=======
	
	//work
	@PostMapping("/elder/add")
	public void addElderTest(@RequestBody Elder elder) {
		elderRepository.save(elder);
>>>>>>> refs/remotes/origin/brand1
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

}
