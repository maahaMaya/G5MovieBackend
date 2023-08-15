package com.sourav.service;

import java.util.List;

import com.sourav.model.Ordered;

public interface OrderedService {
	//add order
	public boolean createOrdered(String emailId);
	
	//get order customer order
	public List<Ordered> getCustomerOrdered(String emailId);
	
	//get all order
	public List<Ordered> getAllOrdered();
}
