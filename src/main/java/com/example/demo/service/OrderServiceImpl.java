package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
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
		HashSet<Order> orderList = new HashSet<Order>();
		List<Order> listOrders = orders.getOrders();
		((Iterable<Order>) orders).forEach(order -> {
			Order filterOrder = listOrders.stream().filter(x -> (order.getPrice() >= 100)).findAny().orElse(null);
			order.setItemName(filterOrder.getItemName());
			order.setPrice(filterOrder.getPrice());
			order.setCustomerName(customerName);
			listOrders.add(order);
		});

		ResponseOrders resorders = new ResponseOrders();
		resorders.setOrders(null);
		LOGGER.info("filterOrderDetails Seervice ENDS");
		return resorders;
	}

}