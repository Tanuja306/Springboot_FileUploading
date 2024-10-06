package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepo extends JpaRepository<Manager,Integer>
{

	@Query("SELECT m FROM Manager m WHERE m.mname LIKE %?1%")
	public List<Manager> search(String keyword);
	
	public Manager findByMname(String mname);
	
	
	 

	
	
}
