package com.cg.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	private int account_id;
	private int account_no;
	@OneToOne(mappedBy="account",fetch=FetchType.EAGER)
	private Customer customer;
	
	@OneToMany(mappedBy="account",fetch=FetchType.EAGER)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private double balance;
	private Timestamp create_date;
	private Timestamp delete_date;
	public int getAccount_id() { 
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getDelete_date() {
		return delete_date;
	}
	public void setDelete_date(Timestamp delete_date) {
		this.delete_date = delete_date;
	}
	



}