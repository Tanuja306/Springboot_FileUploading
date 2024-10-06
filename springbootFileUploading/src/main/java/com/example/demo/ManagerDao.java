package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerDao implements ManagerService
{
     @Autowired   
	ManagerRepo mr;

	@Override
	public void register(Manager m1) {
		mr.save(m1);
		
	}

	@Override
	public List<Manager> getinfo() {
		
		return mr.findAll();
	}

	@Override
	public void deldata(int id) {
		
		mr.deleteById(id);
	}

	@Override
	public Manager editdata(int id) {
		return mr.getById(id);
		
	}

	@Override
	public List<Manager> findAllManager(String keyword) {
		if(keyword!=null)
		{
			
			return mr.search(keyword);	
			
		}
		return (List<Manager>) mr.findByMname(keyword);
		
		
	}
	
	
	
	

	
}
	
	
	
	
	