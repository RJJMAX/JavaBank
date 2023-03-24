package com.maxtrain.bootcamp.sales.order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {
		
	@SuppressWarnings("unused")
	private final String Status_NEW = "NEW";
	private final String Status_REVIEW = "REVIEW";
	private final String Status_APPROVED = "APPROVED";
	@SuppressWarnings("unused")
	private final String Status_REJECTED = "REJECTED";
	
	@Autowired
	private OrderRepository ordRepo;
	
	@GetMapping("reviews")
	public ResponseEntity<Iterable<Order>> getOrdersInReview(){
		Iterable<Order> ordersInReview = ordRepo.findByStatus(Status_REVIEW);
		return new ResponseEntity<Iterable<Order>>(ordersInReview, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Order>> getOrders(){
		Iterable<Order> orders = ordRepo.findAll();
				return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);
		}
	
	@GetMapping("{id}")
	public ResponseEntity<Order> getOrders(@PathVariable int id){
		Optional<Order> order = ordRepo.findById(id);
		if(order.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> postOrder(@RequestBody Order order){
		Order newOrder = ordRepo.save(order);
		return new ResponseEntity<Order>(newOrder, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("review/{id}")
	public ResponseEntity reviewOrder(@PathVariable int id, @RequestBody Order order) {
		String newStatus = order.getTotal() <= 100 ? Status_APPROVED : Status_REVIEW;
		order.setStatus(newStatus);
		return putOrder(id, order);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("approve/{id}")
	public ResponseEntity approveOrder(@PathVariable int id, @RequestBody Order order) {
		order.setStatus(Status_APPROVED);
		return putOrder(id, order);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("reject/{id}")
	public ResponseEntity rejectOrder(@PathVariable int id, @RequestBody Order order) {
		order.setStatus(Status_REJECTED);
		return putOrder(id, order);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("{id}")
	public ResponseEntity<Order> putOrder(@PathVariable int id, @RequestBody Order order){
		if(order.getId() !=id) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		ordRepo.save(order);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteCustomer(@PathVariable int id) {
		Optional<Order> order = ordRepo.findById(id);
		if(order.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		ordRepo.delete(order.get());
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
}
