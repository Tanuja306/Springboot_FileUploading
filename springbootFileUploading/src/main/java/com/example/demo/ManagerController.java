package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerService ms;
	
	
	@RequestMapping("/")
	public String one()
	{
		
		return "Register";
	}
	
	@PostMapping("/savedata")
	public String two(@ModelAttribute("m1") Manager m1,@RequestParam("file") MultipartFile filename) throws Exception
	{
		File f1=new File("C:\\Users\\sai\\java basic\\springbootFileUploading\\src\\main\\resources\\static\\images\\");
		
		String fname=filename.getOriginalFilename();
	   filename.transferTo(new File(f1,fname));
		
	  
	     m1.setFilename(fname);
		ms.register(m1);
		
		
		return "redirect:/display";
	}
	
	
	@GetMapping("/display")
	public String three(Model m)
	{
		List<Manager> l1=ms.getinfo();
		m.addAttribute("temp",l1);
		return "display";
	}
	
	@RequestMapping("/deldata/{id}")
	public String four(@PathVariable int id)
	{
		ms.deldata(id);
		return "redirect:/display";
	}
	
	@RequestMapping("/editdata/{id}")
	public String five(@PathVariable int id,Model m)
	{
		Manager m2=ms.editdata(id);
		m.addAttribute("kk",m2);
		return "edit";
	}
	
	
	@PostMapping("/updatedata")
	public String six(@ModelAttribute("mg") Manager mg, @RequestParam("file") MultipartFile filename) throws Exception
	{
		try {
			
		
        File f1=new File("C:\\Users\\sai\\java basic\\springbootFileUploading\\src\\main\\resources\\static\\images\\");
		
		String fname=filename.getOriginalFilename();
		
	    filename.transferTo(new File(f1,fname));
		}
		catch(IOException e)
		{
		
		Manager m1=new Manager();
		m1.setMid(mg.getMid());
		m1.setMname(mg.getMname());
		m1.setMemail(mg.getMemail());
		m1.setMpass(mg.getMpass());
		m1.setGender(mg.getGender());
		m1.setState(mg.getState());
		m1.setFilename(filename.getOriginalFilename());
		
		ms.register(m1);
		}
		
		return "redirect:/display";
	}


	
	@GetMapping("/search")
     public String nine(Model m,@Param("keyword") String keyword)
     {
		List<Manager> lm=ms.findAllManager(keyword);
		m.addAttribute("temp",lm);
		m.addAttribute("key",keyword);
		return "display";
     }
	
	
	

}
