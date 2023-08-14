package com.sourav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sourav.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	@Query("SELECT c FROM Customer c WHERE ((c.fullName LIKE %?1%) OR (c.emailId LIKE %?1%) OR (c.phoneNumber LIKE %?1%))") 
	public List<Customer> searchCustomerByKeyword(String searchKeyword);
}
