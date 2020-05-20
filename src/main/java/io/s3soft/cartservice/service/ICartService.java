package io.s3soft.cartservice.service;

import io.s3soft.cartservice.api.dto.OrderPlaced;
import io.s3soft.cartservice.dto.CartItemDTO;
import io.s3soft.cartservice.model.Cart;

public interface ICartService {

	Cart getCart(Integer cartId);
	Cart addCartItem(Integer cartId,CartItemDTO cartItemDTO);
	Cart removeCartItem(Integer cartId,String productId);
	Cart updateCartItem(Integer cartId,CartItemDTO  cartItemDTO);
	OrderPlaced placeOrder(Integer cartId);

}
