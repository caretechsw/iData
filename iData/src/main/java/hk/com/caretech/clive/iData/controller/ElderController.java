package hk.com.caretech.clive.iData.controller;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.internal.util.streams.StingArrayCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

import com.mysql.cj.Session;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.repository.ElderRepository;
import javassist.expr.NewArray;
import net.bytebuddy.asm.Advice.Return;

@Controller
public class ElderController {
	
	@Autowired
    private ElderRepository elderRepository;

	Logger logger = LoggerFactory.getLogger("ElderController");
	
	@GetMapping("/")
	@ResponseBody
	public String testConnect(){
		return "connected";	
	}
	
	@GetMapping("/elder_web")
	public String findAll_web(Model model){
		Iterable<Elder> elderList = elderRepository.findAll();
		model.addAttribute("elders" , elderList);
		return "elder";
		}
	
	@GetMapping("/elder_web/id")
	public ModelAndView getElderById_web(@RequestParam int id) {
		Iterable<Elder> elderList = elderRepository.getById(id);
		return new ModelAndView("elder", "elders" , elderList);
	}
	
	@GetMapping("/elder_web/name")
	public ModelAndView getElderByName_web(@RequestParam String name) {
		Iterable<Elder> elderList = elderRepository.getByName(name);
		return new ModelAndView("elder", "elders" , elderList);
	}
	
	@GetMapping("/elder_web/bed_no")
	public ModelAndView getElderByBedNo_web(@RequestParam int bed_no) {
		Iterable<Elder> elderList = elderRepository.getByBedNo(bed_no);
		return new ModelAndView("elder", "elders" , elderList);
	}
	

	@GetMapping("/elder_web/add")
	public String addElder_web(Model model) {
		model.addAttribute("elder", new Elder());
	return "add_elder";
	}
	
	@PostMapping("/elder_web/add")
	public String addElder_web(@ModelAttribute("elder") Elder elder, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
	            return "redirect:/elder_web/add";
	        }
		try {
		 elderRepository.save(elder);
		 Iterable<Elder> elderList = elderRepository.findAll();
		 model.addAttribute("elders", elderList);
		 return "redirect:/elder_web";
		} 
		catch (Exception e) {
			return "oper_exception";
		}
	}
	
	@GetMapping("/elder_web/update")
	public String editElder_web(@RequestParam("id") int id, Model model) {
		Elder elder = elderRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("elder", elder);
	return "edit_elder";
	}
	
	
	@PostMapping("/elder_web/update")
	public String updateElder_web(@ModelAttribute("elder") @RequestBody Elder elder){
		
		try {
		if(elderRepository.findById(elder.getId()).isPresent()){
			 elderRepository.save(elder);
			 return "redirect:/elder_web";}
		 else {throw new RuntimeException("Elder ID not found");
		 }
		 	} catch (Exception e) {
		 		return "oper_exception";
		}
	 }

	
	
	@GetMapping("/elder_web/delete")
	public String deleteElder_web(@RequestParam("id") int id) {
    Elder user = elderRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    elderRepository.delete(user);
    return "redirect:/elder_web";
}
	
	
	//*****************************************************//
	
	@GetMapping("/elder")
	@ResponseBody
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
	@ResponseBody
	public List<Elder> getElderById(@RequestParam int id) {
		return elderRepository.getById(id);
	}
	
	@GetMapping("/elder/name")
	@ResponseBody
	public List<Elder> getElderByName(@RequestParam String name) {
		return elderRepository.getByName(name);
	}
	
	@GetMapping("/elder/bed_no")
	@ResponseBody
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
	public Elder updateElder(@RequestBody Elder elder){
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
