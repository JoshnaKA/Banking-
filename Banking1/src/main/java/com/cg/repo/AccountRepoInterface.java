
package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.pojo.Account;
import com.cg.pojo.Transaction;

@Repository
public interface AccountRepoInterface extends JpaRepository<Account, Integer>{
	

	@Query(value="SELECT a FROM Account a WHERE a.account_id=?1")
	public Account getAccount(int id);
	
	@Query(value="select a from Account a where account_no=?1")
	public Account getAccountByNumber(int account_number);	

	
	@Query(value="SELECT t FROM Transaction t WHERE account_id=?1)")
	public List<Transaction> getTransactions(int id);

	/*@Query(value="Insert into account(balance) values(?2) where account_number=?1 ")
	public void updateAccount(int accountnumber1, double d);*/
}