package com.sourav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{

}
