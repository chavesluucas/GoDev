package tech.testgodev.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tech.testgodev.application.entities.Product;
import tech.testgodev.application.repositories.ProductRepository;
import tech.testgodev.application.services.exceptions.DatabaseException;
import tech.testgodev.application.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public List<Product> getAll(){
		List<Product> listProduct = repository.findAll();
		
		return listProduct;
	}
	
	public Product findById(Integer id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}
	
	public Product save(Product product) {
		return repository.save(product);
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
	
	
	public Product update(Product obj) throws Exception{
		findById(obj.getId());
		return save(obj);
	}
	
}
