package com.example.demo.model;

import java.util.List;

public class ResponceOrder {

	private List<OrderDetailsResponse> responceOrders;

	public ResponceOrder() {

	}

	public ResponceOrder(List<OrderDetailsResponse> responceOrders) {
		super();
		this.responceOrders = responceOrders;
	}

	public List<OrderDetailsResponse> getResponceOrders() {
		return responceOrders;
	}

	public void setResponceOrders(List<OrderDetailsResponse> responceOrders) {
		this.responceOrders = responceOrders;
	}

}
