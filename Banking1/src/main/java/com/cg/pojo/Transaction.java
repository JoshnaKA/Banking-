package com.cg.pojo;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bank_transaction_id;
	private String payment_transaction_id;
	private String description;
	private double amount;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="account_id")
	private Account account;
	private String transaction_type;
	private double available_balance;
	private String status;
	private Timestamp create_date;
	private Timestamp delete_date;

	public int getBank_transaction_id() {
		return bank_transaction_id;
	}

	public void setBank_transaction_id(int bank_transaction_id) {
		this.bank_transaction_id = bank_transaction_id;
	}

	public String getPayment_transaction_id() {
		return payment_transaction_id;
	}

	public void setPayment_transaction_id(String payment_transaction_id) {
		this.payment_transaction_id = payment_transaction_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(double available_balance) {
		this.available_balance = available_balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Transaction [bank_transaction_id=" + bank_transaction_id
				+ ", payment_transaction_id=" + payment_transaction_id
				+ ", description=" + description + ", amount=" + amount
				+ ", account=" + account + ", transaction_type="
				+ transaction_type + ", available_balance=" + available_balance
				+ ", status=" + status + ", create_date=" + create_date
				+ ", delete_date=" + delete_date + "]";
	}

}

