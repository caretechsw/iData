package hk.com.caretech.clive.iData.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Temperature> findAll(){
		return temperatureRepository.findAll();	
	}
	
	
	@GetMapping("/temp/elderid")
	public List<Temperature> getByElderId(@RequestParam String elderid) {
		return temperatureRepository.getByElderId(elderid);
	}
	
//	
//	@PostMapping("/temp/add")
//	public void addTemp(@RequestParam String temperature,@RequestParam String elder_id){
//		temperatureRepository.addTemp(temperature, elder_id);
//		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(temperatureRepository.get().getId()).toUri();
//		return ResponseEntity.created(path).build();*/
//		
//		}
	
	
	//Cannot add or update a child row: a foreign key constraint fails
	@PostMapping("/addtemp")
	public void addTemp(@RequestBody Temperature temp) {
		temperatureRepository.save(temp);
	}
	
	
	@PostMapping("/addtemptest")
	public void addTemptest(@RequestParam String temperature,@RequestParam String elder_id) {
		temperatureRepository.addTemp( temperature, elder_id);
		}
	
	@PersistenceContext
	public EntityManager em;

	public Temperature test(EntityManager em, String elder_id, String elder_id) {
	    TypedQuery<Temperature> query = em.createQuery(
	    		"insert into temperature(temperature, elder_id) values (:temperature, :elder_id)", Temperature.class);
	    return query.setParameter("temperature", temperature).setParameter("elder_id", elder_id).
	    		getSingleResult();
	  } 
	
//    public void d (Elder elder) {
// 
//        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//    
// 
//    // This Method Is Used To Retrieve The 'EntityManager' Object
//   EntityManager entityMgr = emFactoryObj.createEntityManager();
//  
//   String sql = "insert into temperature(temperature, elder_id) values (:temperature, :elder_id)";
//   entityMgr.createNativeQuery(sql).setParameter(position, value)
//   
////   emEntityManager.getTransaction().begin();
//
//        entityMgr.persist(farmObj);
// 
//        entityMgr.getTransaction().commit();
// 
//        entityMgr.clear();
//    }
	
//	 Session session = HibernateUtil.getSessionFactory().openSession();
//     session.beginTransaction();
//     
//     //Add new Employee object
//     EmployeeEntity emp = new EmployeeEntity();
//     emp.setEmail("lokesh@mail.com");
//     emp.setFirstName("lokesh");
//     emp.setLastName("gupta");
//      
//     //Save the employee in database
//     session.save(emp);
//
//     //Commit the transaction
//     session.getTransaction().commit();
//     HibernateUtil.shutdown();
	

	
	
//	
//	@DeleteMapping("/temps/{temid}")
//	public void deleteElder(@PathVariable("id") String temid) {
//		temperatureRepository.deleteById(temid);
//	}
}
}
