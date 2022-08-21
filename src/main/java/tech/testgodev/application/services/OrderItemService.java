package tech.testgodev.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tech.testgodev.application.entities.OrderItem;
import tech.testgodev.application.repositories.OrderItemRepository;
import tech.testgodev.application.services.exceptions.DatabaseException;
import tech.testgodev.application.services.exceptions.ResourceNotFoundException;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository repository;
	
	public List<OrderItem> getAll(){
		List<OrderItem> listOrderItem = repository.findAll();
		
		return listOrderItem;
	}
	
	public OrderItem findById(Integer id) {
		Optional<OrderItem> product = repository.findById(id);
		return product.get();
	}
	
	public OrderItem save(OrderItem orderItem) {
		return repository.save(orderItem);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	public OrderItem update(OrderItem orderItem) throws Exception{
		findById(orderItem.getId());
		return save(orderItem);
	}
	
}
