package io.s3soft.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.s3soft.cartservice.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
