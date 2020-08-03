package hk.com.caretech.clive.iData.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
	
	private static SessionFactory sessionFactory = null;
	
	@PersistenceContext
	public EntityManager em;

	
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
	
	
	@GetMapping("/temp/elder_id")
	public List<Temperature> getByElderId(@RequestParam String elder_id) {
		return temperatureRepository.getByElderId(elder_id);
	}
	
	////Cannot add or update a child row: a foreign key constraint fails
//	//Product Json format object
//	@PostMapping("/temp/add")
//	public void addTempBody(@RequestBody Temperature temp) {
//	temperatureRepository.save(temp);
//	}
//	
	
//	//For the use of Okhttp api from android
//	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
//	public void addTemp(Temperature temp) {
//	temperatureRepository.save(temp);
//	}
	
//	//For the use of Okhttp api from android
//	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
//	public void addTemptest(String temperature,String elder_id) {
//	temperatureRepository.addTemp(temperature, elder_id);
//	}
	
	
	
	
//	//For the use of Okhttp api from android
//	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", 
//			MediaType.APPLICATION_JSON_VALUE},
//			produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<Temperature> addTemp(Temperature temp) {
//		
////		Temperature temp = new Temperature();
////		temp.setTemperature(temperature);
////		temp.setElderID(elder_id);
//	return new ResponseEntity<Temperature>(temp, HttpStatus.OK);
//	}
	
	
	@PostMapping(path = "/temp/add",  consumes = {"application/x-www-form-urlencoded", 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Temperature> addTemp(@RequestParam("temperature") float temperature,
			@RequestParam("elder_id") int elder_id, Temperature temp) {
		
		temp.setTemperature(temperature);
		temp.setElderID(elder_id);
		temp.setTimestamp(new Timestamp(System.currentTimeMillis()));
		temperatureRepository.save(temp);
	    
//	    managerTemp = managerService.save(manager);
//	    if (managerTemp == null) {
//	        return new ResponseEntity("Employee cant be created", HttpStatus.FAILED_DEPENDENCY);
	    //}
	    return new ResponseEntity<Temperature>(temp, HttpStatus.CREATED);
	}
	
	


//	@PostMapping("/addtemp/{temperature}/{elder_id}")
//	public void addTemp(@RequestParam("temperature") float temperature,@RequestParam("elder_id") int elder_id){
//		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(temperatureRepository.get().getId()).toUri();
//		return ResponseEntity.created(path).build();*/
//		
//		}

	

	
	//wait to be deleted?
//	@PostMapping("/temp/add")
//	public void addTemp(@RequestParam String temperature,@RequestParam String elder_id){
//		temperatureRepository.addTemp(temperature, elder_id);
//		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(temperatureRepository.get().getId()).toUri();
//		return ResponseEntity.created(path).build();*/
//		}
	
	
	//wait to be deleted?
//	@PostMapping("/addtemptest")
//	public void addTemptest(@RequestParam String temperature,@RequestParam String elder_id) {
//		temperatureRepository.addTemp(temperature, elder_id);
//		}
	
	
//@PostMapping("/temp/add")
// public void teste(@RequestParam String temperature, @RequestParam String elder_id) {
//	    String queryString = "insert into temperature(temperature, elder_id) value (:temperature, :elder_id)";
//	    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
//	    query.setParameter("temperature", temperature);
//	    query.setParameter("elder_id", elder_id);
//	    query.executeUpdate();
////	    TypedQuery<Temperature> query = em.createQuery(
////	    		"insert into temperature(temperature, elder_id) values (:temperature, :elder_id)", Temperature.class);
////	    return query.setParameter("temperature", temperature).setParameter("elder_id", elder_id).executeUpdate();
//	  }
	
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
//	@DeleteMapping("/temp/{temid}")
//	public void deleteElder(@PathVariable("id") String temid) {
//		temperatureRepository.deleteById(temid);
//	}
}

