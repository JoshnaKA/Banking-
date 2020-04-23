package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.pojo.Customer;
import com.cg.service.AccountService;
import com.cg.service.CustomerService;
import com.cg.service.TransactionService;

@Controller
public class BankController {
	@Autowired
	CustomerService cserv;
	@Autowired
	TransactionService tserv;
	@Autowired
	AccountService aserv;

	@RequestMapping("/login")
	public String loginPageController(ModelMap map, String txnId,
			int accNo, double amount) {

		if (txnId == null || accNo == 0 || amount == 0) {
			String status = " Trasaction failed due to Invalid data ";
			map.addAttribute("status", status);
			map.addAttribute("id", txnId);
			return "paymentgateway";
		} else {
			map.addAttribute("id", txnId);
			map.addAttribute("amount", amount);
			map.addAttribute("account", accNo);
			return "login";
		}

	}

	@RequestMapping("/validate")
	public String validateUserLoginDetails(ModelMap map, String user,
			String pass, double amount, String pay_id, int account_no)
			throws Exception {

		if (cserv.ValidateUser(user, pass)) {
			Customer c = cserv.getCustomerDetails(user);
			map.addAttribute("id", pay_id);
			map.addAttribute("username",
					c.getFirst_name() + "\t" + c.getLast_name());
			map.addAttribute("amount", amount);
			map.addAttribute("account_no", account_no);
			map.addAttribute("user", user);
			return "payment";

		} else {
			map.addAttribute("id", pay_id);
			String status = " Trasaction failed due to Invvalid UserName or Password ";
			map.addAttribute("status", status);
			return "paymentgateway";
		}

	}

	@RequestMapping("/transaction")
	public String transactionMaking(ModelMap map, String user,
			int merchant_account_no, double amount, String id) {

		Customer c = cserv.getCustomerDetails(user);
		int user_account_no = c.getAccount().getAccount_no();
		String status = tserv.makeTransaction(user_account_no,
				merchant_account_no, amount, id);
		map.addAttribute("id", id);
		map.addAttribute("status", status);
		return "paymentgateway";

	}

}