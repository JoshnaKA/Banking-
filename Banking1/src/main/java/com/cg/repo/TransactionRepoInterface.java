package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.pojo.Account;
import com.cg.pojo.Transaction;

public interface TransactionRepoInterface extends JpaRepository<Transaction, Integer>{
	
//	@Query(value="SELECT a FROM Account a WHERE account_no = ?1 OR account_no = ?2")
//	public List<Account> makeTransaction(Account a1, Account a2);

}

