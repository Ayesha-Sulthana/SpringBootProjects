package EmployeeLaptop.EmployeeLaptop.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeLaptop.EmployeeLaptop.system.Model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
