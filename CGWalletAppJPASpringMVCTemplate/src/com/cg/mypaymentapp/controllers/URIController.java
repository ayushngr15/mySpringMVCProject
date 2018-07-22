package com.cg.mypaymentapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndexPage() {
		return "IndexPage";
	}
	
	@RequestMapping(value="/Login")
	public String getLoginPage() {
		return "LoginPage";
	}
	
	@RequestMapping(value="/Registration")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}
	
	
	@RequestMapping(value="/Deposit")
	public String getDepositPage() {
		return "DepositPage";
	}
	
	@RequestMapping(value="/Withdraw")
	public String getWithdrawPage() {
		return "WithdrawPage";
	}
	
	@RequestMapping(value="/FundTransfer")
	public String getFundTransferPage() {
		return "FundTransferPage";
	}
	
	@RequestMapping(value="/ShowTransactions")
	public String ShowTransactionsPage() {
		return "InitialTransactionPage";
	}
	
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
		
	}
	@ModelAttribute("transactionsList")
	public List<String> getTransactions() {
		return new ArrayList<String>();
		
	}
	
}
