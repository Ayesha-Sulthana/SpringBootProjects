package EmployeeLaptop.EmployeeLaptop.system.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeLaptop.EmployeeLaptop.system.DTO.LaptopDTO;
import EmployeeLaptop.EmployeeLaptop.system.Model.Laptop;
import EmployeeLaptop.EmployeeLaptop.system.Repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	LaptopRepository laptopRepository;

	public boolean addLaptop(Laptop lap) {
		
		Optional<Laptop> laptop = laptopRepository.findById(lap.getLapId());
		if(laptop.isPresent())
			return false;
		else
		{
			laptopRepository.save(lap);
			return true;
		}
	}

	public Laptop getLaptopById(int id) 
	{
		Optional<Laptop> laptop = laptopRepository.findById(id);
		if(laptop.isPresent())
		{
			return laptop.get();
		}
		return null;
	}

	public List<Laptop> getAllLaptops() {
		return laptopRepository.findAll();
	}

	public Laptop updateModelById(int id, String name) {
		Optional<Laptop> laptop = laptopRepository.findById(id);
		if(laptop.isPresent())
		{
			Laptop lap = laptop.get();
			lap.setLapName(name);
			laptopRepository.save(lap);
			Optional<Laptop> l = laptopRepository.findById(id);
			if(l.isPresent())
				return l.get();
			else
				return null;
		}
		return null;
	}

	public boolean deleteLaptop(int id) {
		Optional<Laptop> laptop = laptopRepository.findById(id);
		if(laptop.isPresent())
		{
			Laptop lap = laptop.get();
			laptopRepository.delete(lap);
			return true;
		}
		return false;
	}
	
}









/*public boolean addLaptop(LaptopDTO lap) 
{
	Laptop lapt = convertDTOtoEntity(lap);
	Optional<Laptop> laptop = laptopRepository.findById(lapt.getLapId());
	if(laptop.isPresent())
		return false;
	else
	{
		laptopRepository.save(lapt);
		return true;
	}
}



public LaptopDTO getLaptopById(int id) 
{
	Optional<Laptop> laptop = laptopRepository.findById(id);
	if(laptop.isPresent())
	{
		Laptop lap = laptop.get();
		return convertEntityToDto(lap);
	}
	return null;
}

public List<LaptopDTO> getAllLaptops() 
{
	List<Laptop> laptops = laptopRepository.findAll();
	List<LaptopDTO> lapDtos = new ArrayList<>();
	for(Laptop l : laptops)
	{
		lapDtos.add(convertEntityToDto(l));
	}
	return lapDtos;
}

private LaptopDTO convertEntityToDto(Laptop l) {
	
	return new LaptopDTO(l.getLapId(), l.getLapName(), l.getLapModel(), l.getLapWarranty(), l.getEmployee());
}

private Laptop convertDTOtoEntity(LaptopDTO lap) {
	
	return new Laptop(lap.getLapId(), lap.getLapName(), lap.getLapModel(), lap.getLapWarranty(), lap.getEmployee());
}*/