package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.pojo.Customer;

public interface CustomerRepoInterface extends JpaRepository<Customer, Integer>{

	@Query(value="select c from Customer c where user_name=?1")
	Customer getCustomerByUserName(String user_name);
}
