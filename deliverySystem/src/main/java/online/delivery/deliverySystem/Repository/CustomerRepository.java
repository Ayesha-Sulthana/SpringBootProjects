package online.delivery.deliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.delivery.deliverySystem.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
