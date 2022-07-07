package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderDetailsResponse;
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
		List<OrderDetailsResponse> listOrders = new ArrayList();
		((Iterable<Order>) orders).forEach(order -> {
			OrderDetailsResponse orderResponse = new OrderDetailsResponse();
			Order filterOrder = orderList.stream().filter(x -> (order.getPrice() >= 100)).findAny().orElse(null);
			orderResponse.setItemName(filterOrder.getItemName());
			orderResponse.setPrice(filterOrder.getPrice());
			orderResponse.setCustomer(customerName);
			listOrders.add(orderResponse);
		});

		ResponseOrders resorders = new ResponseOrders();
		resorders.setOrders(null);
		LOGGER.info("filterOrderDetails Seervice ENDS");
		return resorders;
	}

}