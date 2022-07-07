package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RequestOrders;
import com.example.demo.service.OrderServiceImpl;

@RestController
public class OrderController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderServiceImpl orderServiceImpl;

	/**
	 * 
	 * @param customerName
	 * @param orders
	 * @return
	 */

	@PostMapping(path = "{customerName}/orders")
	public ResponseEntity<Object> filterOrder(@PathVariable String customerName, @RequestBody RequestOrders orders) {
		LOGGER.info("filterOrder Method of controller started ");
		try {
			return new ResponseEntity<Object>(orderServiceImpl.filterOrderDetails(orders, customerName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}