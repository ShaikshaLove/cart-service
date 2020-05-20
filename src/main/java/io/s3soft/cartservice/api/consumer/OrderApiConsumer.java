package io.s3soft.cartservice.api.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import io.s3soft.cartservice.api.dto.OrderPlaced;
import io.s3soft.cartservice.api.dto.SuccessResponse;
import io.s3soft.cartservice.model.Cart;

@FeignClient(name="order-api-consumer",url = "https://s3order-service.herokuapp.com")
public interface OrderApiConsumer {
	
       @PostMapping("api/orders")
	   public SuccessResponse<OrderPlaced> placeOrder(Cart cart) ;
	 
}
