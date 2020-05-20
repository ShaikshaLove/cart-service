package io.s3soft.cartservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.cartservice.api.dto.OrderPlaced;
import io.s3soft.cartservice.dto.CartItemDTO;
import io.s3soft.cartservice.model.Cart;
import io.s3soft.cartservice.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private ICartService cartService;

	@PostMapping("/{cartId}/add")
	public Cart addLineItem(@PathVariable Integer cartId,@RequestBody CartItemDTO cartItemDTO) {
		return cartService.addCartItem(cartId, cartItemDTO);
	}
	@DeleteMapping("/{cartId}/delete/{cartItemId}")
	public Cart deleteCartItem(@PathVariable Integer cartId,@PathVariable String cartItemId){
		return cartService.removeCartItem(cartId, cartItemId);
	}
	@PutMapping("/{cartId}/update")
	public Cart updateCart(@PathVariable Integer cartId,@RequestBody CartItemDTO  cartItemDTO ) {
		return cartService.updateCartItem(cartId, cartItemDTO);
	}
	@GetMapping("/{cartId}")
	public Cart getCart(@PathVariable Integer cartId) {
		return cartService.getCart(cartId);
	}
	@PostMapping("/{cartId}/conform")
	public OrderPlaced placeOrder(@PathVariable Integer cartId) {
		return cartService.placeOrder(cartId);
	}
}
