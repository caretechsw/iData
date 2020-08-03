package hk.com.caretech.clive.iData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.model.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
	
	//**Methods annotated with @Query only accept "String" type attribute**
	
	@Query(value = "select * from Temperature where temperature.elder_id = ?1" , nativeQuery = true)
	List<Temperature> getByElderId(String elder_id);

	

	@Query(value = "insert into temperature(temperature, elder_id) value (:temperature, :elder_id)",
	  nativeQuery = true)
	void addTemp(String temperature, String elder_id);

}
