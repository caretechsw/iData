package hk.com.caretech.clive.iData.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.repository.ElderRepository;

@Controller
public class ElderController {
	
	@Autowired
    private ElderRepository elderRepository;
	
	Logger logger = LoggerFactory.getLogger("ElderController");
	
	
//return in Json format
//	@GetMapping("/elders")
//	@ResponseBody
//	public List<Elder> findAll(){
//		return elderRepository.findAll();		
//	}
	
	@RequestMapping("/elder")
	public String findAll(Model model){
		//ModelAndView mav = new ModelAndView("elder");
		List<Elder> elderList = elderRepository.findAll();
		//mav.addObject("elders", elderList);
		model.addAttribute("elders", elderList);
		return "elder";
	}
	

//	@RequestMapping("/elder/{id}")
//	public String getElder(@Param("id") int id, Model model) {
//		Optional<Elder> e =  elderRepository.findById(id);
//		model.addAttribute("elders", e.get());
//		return "elder";
//	}
	
	
	//return in Json format
	@GetMapping("/elder/{id}")
	@ResponseBody
	public Optional<Elder> getElderById(@PathVariable int id) {
		Optional<Elder> e = elderRepository.findById(id);
		//model.addAttribute("elders", e);
		return e;
	}
	
	
	@GetMapping("/elderbyBed/{bed_no}")
	@ResponseBody
	public List<Elder> getElderByBedNo(@PathVariable String bed_no) {
		return elderRepository.findByBedNo(bed_no);
	}
	
	
	@PostMapping("/addelder")
	@ResponseBody
	public Elder addElder(@RequestBody Elder elder){
		elderRepository.save(elder);
		return elder;
		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(elder.getId()).toUri();
		
		return ResponseEntity.created(path).build();*/
	}
//	
	
//	@RequestMapping(method = RequestMethod.PUT)
//	//@PutMapping("/updateelder")
//	public Elder updateElder(@RequestBody Elder elder) {
//		return null;
//		
//	}
//	
//	@DeleteMapping("/elder/{id}")
//	public void deleteElder(@PathVariable("id") String id) {
//		elderRepository.deleteById(id);
//	}

}
