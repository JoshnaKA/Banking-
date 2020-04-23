package com.cg.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pojo.Account;
import com.cg.pojo.Transaction;
import com.cg.repo.AccountRepoInterface;
import com.cg.repo.TransactionRepoInterface;

@Service(value="tservice")
public class TransactionService implements TransactionServiceInterface {
	
	@Autowired
	private AccountRepoInterface accountRepo;
	@Autowired
	private TransactionRepoInterface transactionRepo;

	
	
	@Override
	@Transactional 
	public String makeTransaction(int useraccountnumber, int merchantaccountnumber,double amount, String payment_number) {
		if (useraccountnumber != 0) {
			if (merchantaccountnumber != 0) {
				if (payment_number != null) {
					if (amount != 0) {
						Account a1 = accountRepo.getAccountByNumber(useraccountnumber);
						if (a1 != null) {
							Account a2 = accountRepo.getAccountByNumber(merchantaccountnumber);
							if (a2 != null) {
								if (a1.getBalance() < amount) {
									return "Insufficient balance in user Account";
								} else {
										a1.setBalance(a1.getBalance() - amount);
										a2.setBalance(a2.getBalance() + amount);
										
										Transaction transaction1= new Transaction();
										Transaction transaction2 = new Transaction();
										
										transaction1.setAccount(a1);
										transaction1.setAmount(amount);
										transaction1.setPayment_transaction_id(payment_number);
										transaction1.setStatus("Success");
										transaction1.setTransaction_type("Debit");
										transaction1.setAvailable_balance(a1.getBalance());
										Date date = new Date();
										transaction1.setDescription("Amount of "+ amount + " was debited from your account " + a1.getAccount_no()+ " on " +date);
										a1.getTransactions().add(transaction1);
										transactionRepo.save(transaction1);
										
										transaction2.setAccount(a2);
										transaction2.setAmount(amount);
										transaction2.setPayment_transaction_id(payment_number);
										transaction2.setStatus("Success");
										transaction2.setTransaction_type("Credit");
										transaction2.setAvailable_balance(a2.getBalance());
										transaction2.setDescription("Amount of "+ amount + " was credited to your account " + a2.getAccount_no()+ " on " +date);
										a2.getTransactions().add(transaction2);
										transactionRepo.save(transaction2);

									accountRepo.save(a1);
									accountRepo.save(a2);

									return "Success";
								}
							}
							return "Merchant Account doesn't exist";

						}
						return "User Account doesn't exist";

					}
					return "Amount cannot be zero";
				}
				return "PaymentGateway ID cannot be null";

			}
			return "Merchant account cannot be null";
		}
		return "User account cannot be null";

	}

}
