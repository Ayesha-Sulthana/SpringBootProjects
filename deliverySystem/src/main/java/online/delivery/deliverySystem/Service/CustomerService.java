package online.delivery.deliverySystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.delivery.deliverySystem.Model.Customer;
import online.delivery.deliverySystem.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent())
		{
			Customer cust = customer.get();
			return cust;
		}
		else
			return null;
    }

    public boolean createCustomer(Customer cu) 
    {
    	Optional<Customer> customer = customerRepository.findById(cu.getId());
		if(customer.isPresent())
			return false;
		else
		{
			customerRepository.save(cu);
			return true;
		}
    }

    public Customer updateCustomer(int customerId, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
 
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
           
            return customerRepository.save(existingCustomer);
        } 
        else 
        {
            return null; 
        }
    }

    public boolean deleteCustomer(int customerId) 
    {
    	
    	Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent())
		{
			customerRepository.deleteById(customerId);
			return true;
		}
		else
		{
			return false;
		}
    	
    }
}
