package online.delivery.deliverySystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.delivery.deliverySystem.Model.Customer;
import online.delivery.deliverySystem.Model.Order;
import online.delivery.deliverySystem.Repository.CustomerRepository;
import online.delivery.deliverySystem.Repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
    private CustomerRepository customerRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent())
		{
			Order ord = order.get();
			return ord;
		}
		else
			return null;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer cust = customer.get();
            return cust.getOrders();
        } else {
            return null; 
        }
    }
    
    
    public boolean createOrder(Order ord) {
    	Optional<Order> order = orderRepository.findById(ord.getId());
		if(order.isPresent())
			return false;
		else
		{
			orderRepository.save(ord);
			return true;
		}
    }

    public Order updateOrder(int orderId, Order updatedOrder) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) 
        {
            Order existingOrder = order.get();
            existingOrder.setStatus(updatedOrder.getStatus());
            existingOrder.setLength(updatedOrder.getLength());
            existingOrder.setWidth(updatedOrder.getWidth());
            existingOrder.setHeight(updatedOrder.getHeight());
            return orderRepository.save(existingOrder);
        } 
        else 
        {
            return null; 
        }
    }
    

    public boolean deleteOrder(int orderId) 
    {
    	
    	Optional<Order> order = orderRepository.findById(orderId);
		if(order.isPresent())
		{
			 orderRepository.deleteById(orderId);
			 return true;
		}
		else
			return false;
		
    }
}
