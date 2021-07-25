package com.demo.uds.emartorder.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.uds.emartorder.entity.Orders;
import com.demo.uds.emartorder.service.OrderService;

/*
 	OrdersExecutionController :
 		1) Controller responsible for executing the list of orders
 		2) Calls the order service to execute list of orders
 		3) Also returns the list of orders (though in real life we would need to return orders based on dates like 3/6/9 months
 */

@RestController
public class OrdersExecutionController {

	@Autowired
	OrderService orderService;
	
	final String user = "user101";
	
	@PostMapping("/orders/execute")
	@Produces("application/json")
	public ResponseEntity<?> executeOrder(@RequestBody List<Orders> orders) {
		try {
			//in real life we will check in session and if valid then take out the user and submit order
			if(orders == null || orders.isEmpty()) {
				return new ResponseEntity<String>("Orders empty.", HttpStatus.BAD_REQUEST);
			}
			return (new ResponseEntity<String>(orderService.save(orders), HttpStatus.CREATED));
		}catch(Exception exp) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Order execution failed.", exp);
		}
	}
	
	@GetMapping("/orders")
	@Produces("application/json")
	public ResponseEntity<?> viewOrders() {
		try {
			return (new ResponseEntity<List<Orders>>(orderService.findByUserId(user), HttpStatus.OK));
		}catch(Exception exp) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orders not found", exp);
		}
	}
}