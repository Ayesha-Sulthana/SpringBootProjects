package online.delivery.deliverySystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import online.delivery.deliverySystem.Model.Order;
import online.delivery.deliverySystem.Service.OrderService;

@RestController
public class OrderController {

	@Autowired
    private OrderService orderService;

    @GetMapping("/Order/get/allOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/Order/get/{orderId}")
    public Order getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }
    
    @PostMapping("/Order/createOrder")
    public boolean createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/Order/getBycustomer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }
    
    @PutMapping("/Order/update/{orderId}")
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/Order/delete/{orderId}")
    public boolean deleteOrder(@PathVariable int orderId) {
        return orderService.deleteOrder(orderId);
    }
	
	
}
