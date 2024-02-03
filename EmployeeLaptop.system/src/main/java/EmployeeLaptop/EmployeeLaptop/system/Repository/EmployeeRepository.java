package EmployeeLaptop.EmployeeLaptop.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeLaptop.EmployeeLaptop.system.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
