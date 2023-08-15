package com.sourav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.model.Admin;
import com.sourav.model.Cart;
import com.sourav.model.Ordered;
import com.sourav.repository.CartRepository;
import com.sourav.repository.OrderedRepository;

@Service
public class OrderedServiceImpl implements OrderedService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	OrderedRepository orderedRepository;
	
	@Override
	public boolean createOrdered(String emailId) {
		try {
			List<Cart> allCart = cartRepository.findAll();
			int totalQunatity = 0;
			float totalPrice = 0;
			for (Cart cartData : allCart) {
				totalPrice += cartData.getPrice();
				totalQunatity += cartData.getQuantity();
			}
			Ordered ordered = new Ordered(totalQunatity,totalPrice, emailId);
			orderedRepository.save(ordered);
			cartRepository.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Ordered> getCustomerOrdered(String emailId) {
		try {
			return orderedRepository.searchByEmail(emailId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Ordered> getAllOrdered() {
		try {
			return orderedRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
