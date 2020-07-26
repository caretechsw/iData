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

import hk.com.caretech.clive.iData.model.Temperature;
import hk.com.caretech.clive.iData.repository.TemperatureRepository;

@Controller
public class TemperatureController {

	
	@Autowired
    private TemperatureRepository temperatureRepository;
	
	Logger logger = LoggerFactory.getLogger("TemperatureController");
	
	
	
	@RequestMapping("/temp")
	public String findAll(Model model){
		//ModelAndView mav = new ModelAndView("elder");
		List<Temperature> tempList = temperatureRepository.findAll();
		//mav.addObject("elders", elderList);
		model.addAttribute("temps", tempList);
		return "temperature";
	}
	
	@GetMapping("/temps/{temid}")
	public Optional<Temperature> getElder(@PathVariable("temid") int temid) {
		return temperatureRepository.findById(temid);
		
	}
	
	@PostMapping("/addtemps")
	public Temperature addTemp(@RequestBody Temperature temp){
		temperatureRepository.save(temp);
		return temp;
		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(temperatureRepository.get().getId()).toUri();
		return ResponseEntity.created(path).build();*/
	}
	
	
	
//	
//	@DeleteMapping("/temps/{temid}")
//	public void deleteElder(@PathVariable("id") String temid) {
//		temperatureRepository.deleteById(temid);
//	}
}
