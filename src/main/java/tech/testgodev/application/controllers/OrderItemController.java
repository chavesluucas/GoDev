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

import tech.testgodev.application.entities.OrderItem;
import tech.testgodev.application.services.OrderItemService;

@RestController
@RequestMapping("/api/orderItems")
@CrossOrigin("*")
public class OrderItemController {

	@Autowired
	OrderItemService service;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> getAll(){
		List<OrderItem> listOrderItem = service.getAll();
		
		return ResponseEntity.ok().body(listOrderItem);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Integer id){
		OrderItem orderItem = service.findById(id);
		
		return ResponseEntity.ok().body(orderItem);
	}
	
	@PostMapping
	public ResponseEntity<OrderItem> save(@RequestBody OrderItem orderItem){
		orderItem = service.save(orderItem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(orderItem.getId()).toUri();
		return ResponseEntity.created(uri).body(orderItem);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<OrderItem> update(@RequestBody OrderItem orderItem) throws Exception{
		
		return new ResponseEntity<OrderItem>(service.update(orderItem), HttpStatus.OK);
	}
	
}
