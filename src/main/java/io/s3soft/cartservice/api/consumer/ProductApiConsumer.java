package io.s3soft.cartservice.api.consumer;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.s3soft.cartservice.dto.SuccessResponse;
import io.s3soft.cartservice.model.Product;

@Component
public class ProductApiConsumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Product getProduct(String productId) {
		System.out.println(productId);
		String url="https://product-sevice.herokuapp.com/product-service/api/v1/products/"+productId;
		String username="shaiksha";
		String password="shaikshA@1";
		HttpHeaders headers=new HttpHeaders();
		String credentials=username+":"+password;
		byte[] credentilsBytes=credentials.getBytes();
		String encodedCredentialsBytes=new String(Base64.encodeBase64(credentilsBytes));
		headers.add("Authorization", "basic "+encodedCredentialsBytes);
		HttpEntity<String> requestMessage=new HttpEntity<String>(headers);
		URI uri=URI.create(url);
		ResponseEntity<SuccessResponse> res=restTemplate.exchange(uri, HttpMethod.GET, requestMessage, SuccessResponse.class);
		SuccessResponse sres=res.getBody();
		System.out.println(sres.getContent());
		ObjectMapper mapper=new ObjectMapper();
		Product p=mapper.convertValue(sres.getContent(), Product.class);
		System.out.println(p);
        return p;
	}
	
}
