package com.example.demo.service;

import com.example.demo.model.RequestOrders;
import com.example.demo.model.ResponseOrders;

public interface OrderService {
	public ResponseOrders filterOrderDetails(RequestOrders orders, String customerName);
	
}