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

import com.example.demo.model.ResponceOrder;
import com.example.demo.model.Order;
import com.example.demo.model.RequestOrderItems;
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
	public ResponseEntity<ResponceOrder> filterOrder(@PathVariable String customerName,
			@RequestBody RequestOrderItems orders) {
		LOGGER.info("filterOrder Method of controller started ");
		try {
		if (orders != null && !orders.getOrderlist().isEmpty()) {
			orders.getOrderlist().forEach(order -> {
				Order placedOrder = new Order(order.getId(), order.getItemName(), order.getQuantity(),
						order.getPrice());

				orderServiceImpl.createOrder(placedOrder);

			});
			LOGGER.info("filterOrder Method of controller Ended ");
		}

		return new ResponseEntity<ResponceOrder>(
				orderServiceImpl.filterOrderDetails(orderServiceImpl.getOrderList(), customerName), HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

}