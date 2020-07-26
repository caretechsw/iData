package hk.com.caretech.clive.iData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.model.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
	
	
	
	@Query(value = "select * from Temperature where temperature.elder_id = ?1" , nativeQuery = true)
	List<Elder> findByElderID(String elder_id);
	

}
