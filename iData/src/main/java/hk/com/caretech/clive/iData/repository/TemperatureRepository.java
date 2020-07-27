package hk.com.caretech.clive.iData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hk.com.caretech.clive.iData.model.Elder;
import hk.com.caretech.clive.iData.model.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
	
	
	
	@Query(value = "select * from Temperature where temperature.elder_id = ?1" , nativeQuery = true)
	List<Temperature> findByElderID(int elder_id);
	
	
	@Modifying
	@Query(value = "insert into temperature(temperature, elder_id) values (:temperature, :elder)",
	  nativeQuery = true)
	void addTemp(@Param("temperature")float temperature, @Param("elder") int elder);

}
