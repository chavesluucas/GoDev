package tech.testgodev.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.testgodev.application.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
