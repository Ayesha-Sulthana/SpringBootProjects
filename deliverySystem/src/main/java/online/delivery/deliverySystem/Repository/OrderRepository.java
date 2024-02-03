package online.delivery.deliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.delivery.deliverySystem.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
