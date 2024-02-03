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

import EmployeeLaptop.EmployeeLaptop.system.DTO.EmployeeDTO;
import EmployeeLaptop.EmployeeLaptop.system.Model.Employee;
import EmployeeLaptop.EmployeeLaptop.system.Service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
		
	@RequestMapping(value = "/employee/add",  method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee emp){
		return employeeService.addEmployee(emp);
	}
	
	@GetMapping("/employee/get/{id}")
	public Employee getEmployeeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/employee/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employee/updateName/{id}")
	public Employee updateNameById(@PathVariable int id,@RequestBody String name){
		return employeeService.updateNameById(id,name);
	}
	
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
}















/*
@RequestMapping(value = "/Employee/add",  method = RequestMethod.POST)
public boolean addEmployee(@RequestBody EmployeeDTO empDto)
{
	return employeeService.addEmployee(empDto);
}

@GetMapping("/Employee/get/{id}")
public EmployeeDTO getEmployeeById(@PathVariable int id)
{
	return employeeService.getEmployeeById(id);
}

@GetMapping("/Employee/getAllEmployees")
public List<EmployeeDTO> getAllEmployees()
{
	return employeeService.getAllEmployees();
}*/
