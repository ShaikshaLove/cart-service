package io.s3soft.cartservice.dto;

public class CartItemDTO {
	private Integer quantity;
	private String productId;
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
	
	@Override
	public String toString() {
		return "CartItem [quantity=" + quantity + ", productId=" + productId + "]";
	}
	public CartItemDTO() {
		super();
	}
}
