package io.s3soft.cartservice.api.dto;

import java.util.Date;

public class OrderPlaced {
	
	private String orderId;
	private Date orderDate;
	private double orderAmount;
	private OrderStatus orderSatus;
	
	
	public OrderStatus getOrderSatus() {
		return orderSatus;
	}
	public void setOrderSatus(OrderStatus orderSatus) {
		this.orderSatus = orderSatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Override
	public String toString() {
		return "OrderPlaced [orderId=" + orderId + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount + "]";
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderPlaced() {
		super();
	}
	public OrderPlaced(String orderId, Date orderDate, double orderAmount, OrderStatus orderSatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.orderSatus = orderSatus;
	}


}
