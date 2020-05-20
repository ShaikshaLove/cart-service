package io.s3soft.cartservice.service.impl;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.s3soft.cartservice.api.consumer.OrderApiConsumer;
import io.s3soft.cartservice.api.consumer.ProductApiConsumer;
import io.s3soft.cartservice.api.dto.OrderPlaced;
import io.s3soft.cartservice.api.dto.SuccessResponse;
import io.s3soft.cartservice.dto.CartItemDTO;
import io.s3soft.cartservice.model.Cart;
import io.s3soft.cartservice.model.CartItem;
import io.s3soft.cartservice.model.Product;
import io.s3soft.cartservice.repository.CartRepository;
import io.s3soft.cartservice.service.ICartService;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductApiConsumer productApiConsumer;

	@Autowired
	private OrderApiConsumer orderApiConsumer;

	@Override
	public Cart getCart(Integer cartId) {
		Cart cart=null;
		try {
			cart=cartRepository.findById(cartId).orElseThrow(()->new RuntimeException());
		}catch (RuntimeException e) {
			cart=cartRepository.save(new Cart(cartId));
		}
		return cart;
	}

	@Override
	public Cart addCartItem(Integer cartId, CartItemDTO cartItemDTO) {
		Cart cart=getCart(cartId);
		if(cartItemDTO!=null) {
			Product product=productApiConsumer.getProduct(cartItemDTO.getProductId());
			int quantity=cartItemDTO.getQuantity();
			double cost=quantity*product.getPrice();
			CartItem cartItem=new CartItem();
			cartItem.setQuantity(quantity);
			cartItem.setProductId(cartItemDTO.getProductId());
			cartItem.setCost(cost);
			synchronized(this) {
				cart.getCartItems().add(cartItem);
				cart.setTotalCost(cart.getTotalCost()+cost);
				cart=cartRepository.save(cart);
			}
		}
		return cart;
	}

	@Override
	public Cart removeCartItem(Integer cartId, String producttId) {
		Cart cart=getCart(cartId);
		Iterator<CartItem> iterator=cart.getCartItems().iterator();
		synchronized(this) {

			while(iterator.hasNext()) {
				CartItem cartItem=iterator.next();
				if(cartItem.getProductId().equals(producttId)) {
					cart.setTotalCost(cart.getTotalCost()-cartItem.getCost());

					iterator.remove();
				}
			}
			cart=cartRepository.save(cart);
			}
		return cart;
	}

	@Override
	public Cart updateCartItem(Integer cartId,CartItemDTO cartItemDTO) {
		Cart  cart=getCart(cartId);
		for(CartItem cartItem:cart.getCartItems()) {
			if(cartItem.getProductId().equals(cartItemDTO.getProductId())) {
				synchronized(this) {
					cart.setTotalCost(cart.getTotalCost()-cartItem.getCost());
					Product product=productApiConsumer.getProduct(cartItem.getProductId());
					double newCost=product.getPrice()*cartItemDTO.getQuantity();
					cartItem.setCost(newCost);
					cartItem.setQuantity(cartItemDTO.getQuantity());
					cart.setTotalCost(cart.getTotalCost()+newCost);
					cart=cartRepository.save(cart);
				}
			}
		}
		return cart;
	}

	@Override
	public OrderPlaced placeOrder(Integer cartId) {
		Cart cart=getCart(cartId);
		SuccessResponse<OrderPlaced> res=orderApiConsumer.placeOrder(cart);
		clearCart(cart);
		return res.getContent();
	}
	
	
	private void clearCart(Cart cart) {
		cart.setCartItems(new ArrayList<CartItem>());
		cart.setTotalCost(0.0);
		cartRepository.save(cart);
	}






}
