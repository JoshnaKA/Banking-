package com.cg.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pojo.Customer;
import com.cg.repo.CustomerRepoInterface;

@Service(value = "cservice")
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepoInterface customerRepo;


//	@Override
//	public String ValidateUser(String user_name, String password) {
//		if(user_name!=null){
//			if(password!=null){
//				Customer c = customerRepo.getCustomerByUserName(user_name);
//				if(c!=null){
//					if(c.getPassword().trim().equals(password.trim())){
//						return "Password matched";
//					}
//					return "Password doesn't match";
//					
//				}
//				return "User doesn't exist";
//				
//			}
//			return "Password cannot be null";
//			
//		}
//return "User name can't be null";
//
//	}
	
	

	public Customer getCustomerDetails(String user){
		return customerRepo.getCustomerByUserName(user);
	}


@Override
public boolean ValidateUser(String user_name, String password) {
	if(user_name == null || password == null)
		return false;
	Customer c = customerRepo.getCustomerByUserName(user_name);
	if(c == null)
		return false;
	if(c.getPassword().trim().equals(password.trim()))
		return true;
	
	return false;

	
}


}