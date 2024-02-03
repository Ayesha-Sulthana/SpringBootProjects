package EmployeeLaptop.EmployeeLaptop.system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import EmployeeLaptop.EmployeeLaptop.system.DTO.LaptopDTO;
import EmployeeLaptop.EmployeeLaptop.system.Model.Laptop;
import EmployeeLaptop.EmployeeLaptop.system.Service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	
	@RequestMapping(value = "/laptop/add", method = RequestMethod.POST)
	public boolean addLaptop(@RequestBody Laptop lap)
	{
		return laptopService.addLaptop(lap);
	}
	
	@RequestMapping(value="/laptop/get/{id}", method=RequestMethod.GET)
	public Laptop getLaptopById(@PathVariable int id)
	{
		return laptopService.getLaptopById(id);
	}
	
	@GetMapping("/laptop/getAll")
	public List<Laptop> getAllLaptops()
	{
		return laptopService.getAllLaptops();
	}
	
	@PutMapping("/laptop/updateName/{id}")
	public Laptop updateModelById(@PathVariable int id,@RequestBody String name)
	{
		return laptopService.updateModelById(id,name);
	}
	
	@RequestMapping(value = "/laptop/delete/{id}", method = RequestMethod.DELETE)
	public boolean deleteLaptop(@PathVariable int id)
	{
		return laptopService.deleteLaptop(id);
	}
	
}

















/*
@RequestMapping(value = "/Laptop/add", method = RequestMethod.POST)
public boolean addLaptop(@RequestBody LaptopDTO lapDto)
{
	return laptopService.addLaptop(lapDto);
}

@GetMapping("/Laptop/get/{id}")
public LaptopDTO getLaptopById(@PathVariable int id)
{
	return laptopService.getLaptopById(id);
}

@GetMapping("/Laptop/getAllLaptops")
public List<LaptopDTO> getAllEmployees()
{
	return laptopService.getAllLaptops();
}*/