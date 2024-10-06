package com.example.demo;

import java.util.List;

public interface ManagerService {
	
	public void register(Manager m1);
	
	public List<Manager> getinfo();
	
	
	public void deldata(int id);
	
	public Manager editdata(int id);

	//public List<Manager> searchByName(String mname);

	
    
   public List<Manager> findAllManager(String keyword);

	
    
    
	
	

}
