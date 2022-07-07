package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.ResponceOrder;
import com.example.demo.model.Order;

public interface OrderService {
	public void createOrder(Order o);

	public ResponceOrder filterOrderDetails(Set<Order> order, String customerName);

}