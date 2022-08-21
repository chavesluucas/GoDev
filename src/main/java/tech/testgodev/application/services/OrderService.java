package tech.testgodev.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tech.testgodev.application.entities.Order;
import tech.testgodev.application.repositories.OrderRepository;
import tech.testgodev.application.services.exceptions.DatabaseException;
import tech.testgodev.application.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	//GetAll
	public List<Order> getAll(){
		List<Order> list = repository.findAll();
		
		return list;
	}
	
	//FindById
	public Order findById(Integer id) {
		Optional<Order> order = repository.findById(id);
		
		return order.get();
	}
	
	//Delete
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch( EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//save
	public Order save(Order order) {
		return repository.save(order);
	}
	
	//update
	public Order update(Order obj) throws Exception{
		findById(obj.getId());
		return save(obj);
	}
	
}
