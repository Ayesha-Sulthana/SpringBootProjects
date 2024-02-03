package EmployeeLaptop.EmployeeLaptop.system.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeLaptop.EmployeeLaptop.system.DTO.EmployeeDTO;
import EmployeeLaptop.EmployeeLaptop.system.Model.Employee;
import EmployeeLaptop.EmployeeLaptop.system.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public boolean addEmployee(Employee emp) {
		
		Optional<Employee> employee = employeeRepository.findById(emp.getEmpId());
		if(employee.isPresent())
			return false;
		else
		{
			employeeRepository.save(emp);
			return true;
		}
	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
			return employeeRepository.findAll();	
	}

	public Employee updateNameById(int id, String name) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			Employee emp = employee.get();
			emp.setEmpName(name);
			employeeRepository.save(emp);
			Optional<Employee> e = employeeRepository.findById(id);
			if(e.isPresent())
				return e.get();
			else
				return null;
		}
		return null;
		
	}

	public boolean deleteEmployee(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			Employee emp = employee.get();
			employeeRepository.delete(emp);
			return true;
		}
		return false;
	}	
}




















/*
public boolean addEmployee(EmployeeDTO empDto) {
	
	Employee e = convertDTOtoEntity(empDto);
	Optional<Employee> employee = employeeRepository.findById(e.getEmpId());
	if(employee.isPresent())
		return false;
	else
	{
		employeeRepository.save(e);
		return true;
	}
}

public EmployeeDTO getEmployeeById(int id) 
{
	Optional<Employee> employee = employeeRepository.findById(id);
	if(employee.isPresent())
	{
		Employee emp = employee.get();
		return convertEntitytoDTO(emp);
	}
	return null;
}



public List<EmployeeDTO> getAllEmployees() {
	
	List<Employee> employees = employeeRepository.findAll();
	List<EmployeeDTO> empDtos = new ArrayList<>();
	for(Employee emp : employees)
	{
		empDtos.add(convertEntitytoDTO(emp));
	}
	return empDtos;
}


private Employee convertDTOtoEntity(EmployeeDTO empDto) {
	return new Employee(empDto.getEmpId(), empDto.getEmpName(), empDto.getSalary(), empDto.getEmpJoiningDate());
}

private EmployeeDTO convertEntitytoDTO(Employee emp) {
	
	return new EmployeeDTO(emp.getEmpId(), emp.getEmpName(), emp.getSalary(), emp.getEmpJoiningDate());
}*/