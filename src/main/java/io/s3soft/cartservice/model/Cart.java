package io.s3soft.cartservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Cart {
	
	@Id
    private  Integer customerId;
	private Double totalCost;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cartId")
	private List<CartItem> cartItems=new ArrayList<>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Cart() {
		super();
	}
	public Cart(Integer customerId) {
		super();
		this.customerId = customerId;
		this.totalCost=0.0;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}



	@Override
	public String toString() {
		return "Cart [customerId=" + customerId + ", cartItems=" + cartItems + "]";
	}
}
