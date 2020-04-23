package com.cg.service;

public interface TransactionServiceInterface {
	
	String makeTransaction(int account1, int account2, double amount, String payment_number);
	
}
