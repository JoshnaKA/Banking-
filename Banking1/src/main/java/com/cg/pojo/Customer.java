package com.cg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Customer {
	@Id
	private int customer_id;
	private String user_name;
	@OneToOne
	@JoinColumn(name="account_id")
	private Account account;
	private String first_name;
	private String last_name;
	private String password;
	

	public String getFirst_name() {
		return first_name;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", user_name="
				+ user_name + ", account=" + account + ", first_name="
				+ first_name + ", last_name=" + last_name + ", password="
				+ password + "]";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


}
