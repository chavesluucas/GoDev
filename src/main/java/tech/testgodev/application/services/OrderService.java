package tech.testgodev.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tech.testgodev.application.entities.SalesOrder;
import tech.testgodev.application.repositories.OrderRepository;
import tech.testgodev.application.services.exceptions.DatabaseException;
import tech.testgodev.application.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	//GetAll
	public List<SalesOrder> getAll(){
		List<SalesOrder> list = repository.findAll();
		
		return list;
	}
	
	//FindById
	public SalesOrder findById(Integer id) {
		Optional<SalesOrder> order = repository.findById(id);
		
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
	public SalesOrder save(SalesOrder order) {
		return repository.save(order);
	}
	
	//update
	public SalesOrder update(SalesOrder obj) throws Exception{
		findById(obj.getId());
		return save(obj);
	}
	
}
