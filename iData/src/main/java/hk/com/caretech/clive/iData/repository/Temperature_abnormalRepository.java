package hk.com.caretech.clive.iData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import hk.com.caretech.clive.iData.model.Temperature_abnormal;

@Repository
public interface Temperature_abnormalRepository extends CrudRepository<Temperature_abnormal, String> {

	
	@Query(value = "select * from temperature_abnormal where elder_id = ?1" , nativeQuery = true)
	List<Temperature_abnormal> getByElderId(int elder_id);
	
	@Query(value = "select * from temperature_abnormal where ev_timestamp = ?1" , nativeQuery = true)
	Temperature_abnormal getByDev_timestamp(String dev_timestamp);
	

//	@Query(value = "insert into temperature(temperature, elder_id) value (:temperature, :elder_id)",
//	  nativeQuery = true
//	void addTemp(String temperature, String elder_id);

}
