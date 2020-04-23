package com.cg.service;

import java.util.List;

import com.cg.exceptions.AccountIdCannotBeZero;
import com.cg.exceptions.AccountNumberShouldNotBEZero;
import com.cg.exceptions.InvalidAccountNumber;
import com.cg.pojo.Transaction;

public interface AccountServInterface {

	double showBalance(int account_id) throws AccountIdCannotBeZero, InvalidAccountNumber;
	List<Transaction> getTransactions(int account_number) throws InvalidAccountNumber, AccountNumberShouldNotBEZero;
}
 