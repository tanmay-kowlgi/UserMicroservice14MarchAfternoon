package com.infosys.project.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.project.order.dto.OrderDTO;
import com.infosys.project.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment environment;
	
	@Autowired
	OrderService orderService;

	// Fetches order details of a specific order
	@GetMapping(value = "/orders/{orderid}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getspecificOrderDetails(@PathVariable int orderid) {
		logger.info("Orderdetails request for user {}", orderid);

		return orderService.getSpecificOrder(orderid);
	}
	@GetMapping(value = "/orders",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getAllOrderDetails() {
		logger.info("Orderdetails");

		return orderService.getOrderDetails();
	}
	@PostMapping(value = "/orders/placeOrder",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void placeOrder(@RequestBody OrderDTO orderDTO) {
		logger.info("PlacingOrder request for User {} ", orderDTO);
		orderService.placeOrder(orderDTO);
	}
	@GetMapping(value = "/orders/buyer/{buyerId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public double getOrderAmountByBuyerId(@PathVariable int buyerId) throws Exception {
		double amount = orderService.getOrderAmountUsingBuyerId(buyerId);
		return amount;
		
		
	}
	@PutMapping(value = "/orders/amount/{buyerId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> disableProductsUsingSellerId(@PathVariable Integer buyerId,@RequestBody OrderDTO orderDTO) {
		ResponseEntity<String> response = null;
		orderService.changeAmountAccordingToRewardPoints(buyerId, orderDTO.getAmount());
		String successMessage = "Good job";
		response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
	    return response;
		
	}

	
}
