package tech.testgodev.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.testgodev.application.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
