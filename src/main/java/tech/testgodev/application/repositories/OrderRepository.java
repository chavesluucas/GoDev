package tech.testgodev.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.testgodev.application.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
