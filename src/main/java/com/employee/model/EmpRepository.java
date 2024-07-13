package com.employee.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	   @Transactional
	   @Query("SELECT e FROM Employee e WHERE e.seatingChart IS  NULL")
	    List<Employee> findAvailableEmployees();
	

}