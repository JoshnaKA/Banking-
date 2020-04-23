package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exceptions.AccountIdCannotBeZero;
import com.cg.exceptions.AccountNumberShouldNotBEZero;
import com.cg.exceptions.InvalidAccountNumber;
import com.cg.pojo.Account;
import com.cg.pojo.Transaction;
import com.cg.repo.AccountRepoInterface;

@Service(value="aservice")
public class AccountService implements AccountServInterface {
	
	@Autowired
	private AccountRepoInterface accountRepo;
	
	

	@Override
	public double showBalance(int account_id) throws AccountIdCannotBeZero, InvalidAccountNumber {
		if(account_id!=0){
			Account a = accountRepo.getAccount(account_id);
		if(a!=null){
			return a.getBalance();
			
		}
		else throw new InvalidAccountNumber();
		}
		else
		throw new AccountIdCannotBeZero();
	}

	@Override
	public List<Transaction> getTransactions(int account_number) throws InvalidAccountNumber, AccountNumberShouldNotBEZero {
		if(account_number!=0){
			Account a=accountRepo.getAccountByNumber(account_number);
			if(a!=null){
				return accountRepo.getTransactions(a.getAccount_id());
			}
			else 
				throw new InvalidAccountNumber();
		}
		else
			throw new AccountNumberShouldNotBEZero();		
		
	}
	
	public Account findById(int id){
		 return accountRepo.getAccount(id);
	}
	
	
}