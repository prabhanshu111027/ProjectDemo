package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.RequestOrders;
import com.example.demo.model.ResponseOrders;
import com.example.demo.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public ResponseOrders filterOrderDetails(RequestOrders orders, String customerName) {
		LOGGER.info("filterOrderDetails Seervice started");
		ResponseOrders resorders = new ResponseOrders();
		List<Order> listOrders = orders.getOrders();
		List<Order> filterOrders = listOrders.stream().filter(order -> (order.getPrice() >= 100))
				.collect(Collectors.toList());
		resorders.setCustomerName(customerName);
		resorders.setOrders(filterOrders);
		LOGGER.info("filterOrderDetails Seervice ENDS");
		return resorders;
	}

}