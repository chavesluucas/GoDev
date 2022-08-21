package tech.testgodev.application.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.testgodev.application.entities.Order;
import tech.testgodev.application.services.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		List<Order> listOrder = service.getAll();
		
		return ResponseEntity.ok().body(listOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable Integer id){
		Order order = service.findById(id);
		
		return ResponseEntity.ok().body(order);	
	}
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order){
		order = service.save(order);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Order> update(@RequestBody Order order) throws Exception{
		
		return new ResponseEntity<Order>(service.update(order), HttpStatus.OK);
	}
	
}
