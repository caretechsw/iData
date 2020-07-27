package hk.com.caretech.clive.iData.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hk.com.caretech.clive.iData.model.Elder;


public interface ElderRepository extends JpaRepository<Elder, Integer> {
	
	
	//**Methods annotated @Query only accept "String" type attribute**
	
	@Query(value = "select * from Elder where elder.id = ?1" , nativeQuery = true)
	List<Elder> getElderById(String id);
	
	@Query(value = "select * from Elder where elder.name LIKE %?1%" , nativeQuery = true)
	List<Elder> getElderByName(String name);
	
	@Query(value = "select * from Elder where elder.bed_no = ?1" , nativeQuery = true)
	List<Elder> getElderByBedNo(String bed_no);

	

	@Query(value = "insert into elder(name, bed_no) values (:name, :bed_no)",
	  nativeQuery = true)
	void addElder(@Param("name")String name, @Param("bed_no") int bed_no);
	
	
//	@Modifying
//	@Query
//	update
	
	
//	@Modifying
//	@Query("delete from Elder e where e.id = ?1")
//	void deleteElderById();
	
}
