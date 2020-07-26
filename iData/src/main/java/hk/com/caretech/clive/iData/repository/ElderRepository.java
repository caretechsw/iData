package hk.com.caretech.clive.iData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hk.com.caretech.clive.iData.model.Elder;


public interface ElderRepository extends JpaRepository<Elder, Integer> {
	
	
	//**Methods annotated @Query only accept "String" type attribute**
	
	
	@Query(value = "select * from Elder where elder.bed_no = ?1" , nativeQuery = true)
	List<Elder> findByBedNo(String bed_no);
	
	@Query(value = "select * from Elder where elder.name = ?1" , nativeQuery = true)
	List<Elder> findByName(String name);
	
	
	
//	@Modifying
//	@Query
//	update
	
	
//	@Modifying
//	@Query("delete from Elder e where e.id = ?1")
//	void deleteElderById();
	
}
