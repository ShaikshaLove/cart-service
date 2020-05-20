package io.s3soft.cartservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartItem {
	@Id
	private String productId;
	private Integer quantity;
	private Double cost;

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public CartItem() {
		super();
	}
}
