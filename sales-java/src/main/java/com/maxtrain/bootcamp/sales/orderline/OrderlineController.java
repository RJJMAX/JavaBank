package com.maxtrain.bootcamp.sales.orderline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/orderlines")
public class OrderlineController {
	
	@Autowired
	private OrderlineRepository olineRepo;
	
	@GetMapping
	public ResponseEntity<Iterable<Orderline>> getOrderlines(){
		Iterable<Orderline> orderlines = olineRepo.findAll();
		return new ResponseEntity<Iterable<Orderline>>(orderlines, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Orderline> getOrderlines(@PathVariable int id){
		Optional<Orderline> orderline = olineRepo.findById(id);
		if(orderline.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Orderline>(orderline.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Orderline> postOrderline(@RequestBody Orderline orderline){
		Orderline newOrderline = olineRepo.save(orderline);
		return new ResponseEntity<Orderline>(newOrderline, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("{id}")
	
	public ResponseEntity<Orderline> putOrderlin(@PathVariable int id, @RequestBody Orderline orderline){
		if(orderline.getId() !=id) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		olineRepo.save(orderline);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteCustomer(@PathVariable int id) {
		Optional<Orderline> orderline = olineRepo.findById(id);
		if(orderline.isEmpty()) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	olineRepo.delete(orderline.get());
	return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
