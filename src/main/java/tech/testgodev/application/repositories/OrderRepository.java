package tech.testgodev.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.testgodev.application.entities.SalesOrder;

public interface OrderRepository extends JpaRepository<SalesOrder, Integer>{

}
