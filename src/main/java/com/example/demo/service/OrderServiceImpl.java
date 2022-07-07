package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderDetailsResponse;
import com.example.demo.model.ResponceOrder;
import com.example.demo.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	HashSet<Order> order = new HashSet<Order>();

	@Override
	public void createOrder(Order o) {
		order.add(o);

	}

	@Override
	public ResponceOrder filterOrderDetails(Set<Order> orders, String customerName) {
		LOGGER.info("filterOrderDetails Seervice started");
		HashSet<Order> orderList = new HashSet<Order>();
		List<OrderDetailsResponse> listOrders = new ArrayList();
		orders.forEach(order -> {
			OrderDetailsResponse orderResponse = new OrderDetailsResponse();
			orderResponse.setItemName(order.getItemName());
			orderResponse.setPrice(order.getPrice());
			orderResponse.setCustomer(customerName);
			if (order.getPrice() >= 100)
				listOrders.add(orderResponse);
		});
		ResponceOrder resorders = new ResponceOrder();

		resorders.setResponceOrders(listOrders);
		order = orderList;
		LOGGER.info("filterOrderDetails Seervice ENDS");
		return resorders;
	}

	public HashSet<Order> getOrderList() {

		return order;

	}

}