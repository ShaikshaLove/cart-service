package io.s3soft.cartservice.dto;

public class UpdateCartItemDTO {

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UpdateCartItemDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UpdateCartItemDTO [quantity=" + quantity + "]";
	}



}
