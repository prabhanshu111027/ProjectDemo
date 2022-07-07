package com.example.demo.model;

import java.util.List;

public class RequestOrderItems {
	private int id;
 private List<Order> orderlist;

 public RequestOrderItems() {

	}

public RequestOrderItems(int id, List<Order> orderlist) {
	super();
	this.id = id;
	this.orderlist = orderlist;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<Order> getOrderlist() {
	return orderlist;
}
public void setOrderlist(List<Order> orderlist) {
	this.orderlist = orderlist;
}


}