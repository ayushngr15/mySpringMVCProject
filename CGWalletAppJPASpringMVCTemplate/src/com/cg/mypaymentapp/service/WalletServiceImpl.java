package com.cg.mypaymentapp.service;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.persister.walking.spi.WalkingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.CustomerRepo;
import com.cg.mypaymentapp.repo.TransactionsRepo;


@Component(value = "walletServices")
public class WalletServiceImpl implements WalletService 
{

	@Autowired(required=true)
	private CustomerRepo repo;
	@Autowired(required=true)
	private TransactionsRepo trepo;
	private Customer customer1;
	private Customer customer2;
	private Wallet wallet;
	private Map<String,Customer> data1;
	private BigDecimal updatedBalance1;
	private BigDecimal updatedBalance2;
	 private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public WalletServiceImpl() 
	{
		//repo = new WalletRepoImpl();
		
		data1 = new HashMap<String, Customer>();
	}
	public WalletServiceImpl(Map<String, Customer> data)
	{
		
	}
	public WalletServiceImpl(CustomerRepo repo) 
	{
		super();
		this.repo = repo;
	}

	

	@Override
	public Customer createAccount(Customer customer) {
			
	    return repo.save(customer);

	}

	@Override
	public Customer showBalance(String mobileNo) 
	{
		
		customer1 = repo.findOne(mobileNo);
		if(customer1 != null)
		{
			
			return customer1;
		}
		else
			throw new InvalidInputException("No such mobile number exists.");
	}
	
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) 
	{
		
		customer1=new Customer() ;
		
		customer1 = repo.findOne(mobileNo);
		
		updatedBalance1 = null;
		
		updatedBalance1 = customer1.getWallet().getBalance().add(amount);
		
		wallet = new Wallet(updatedBalance1);
        customer1.setWallet(wallet);
		
        repo.delete(mobileNo);
		
		
		
		Date dateOfTransaction = new Date();
		String details = "Wallet with mobile number: "+customer1.getMobileNo()+" credited with "+ amount+" on "+dateFormat.format(dateOfTransaction)+" with Updated balance: "+customer1.getWallet().getBalance();
		Transactions transactions = new Transactions();
		transactions.setMobileNo(mobileNo);
		transactions.setTransactionDetails(details);
		
		trepo.save(transactions);
		
		if(repo.save(customer1) != null)
		{
			
			return repo.save(customer1);
		}
		else
			throw new InvalidInputException("No such mobile number exists.");
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		
		customer1=new Customer() ;
		customer1 = repo.findOne(mobileNo);
		if(customer1 != null) {
			updatedBalance1 = customer1.getWallet().getBalance();
			int comp = updatedBalance1.intValue()-amount.intValue();
	        
			if(comp>0) {
				updatedBalance1 = null;
				updatedBalance1 = customer1.getWallet().getBalance().subtract(amount);
				
				wallet = new Wallet(updatedBalance1);
		        customer1.setWallet(wallet);
				
		        repo.delete(mobileNo);
				
				
				Date dateOfTransaction = new Date();
				String details = "Wallet with mobile number: "+customer1.getMobileNo()+" debited with "+ amount+" on "+dateFormat.format(dateOfTransaction)+" with Updated balance: "+customer1.getWallet().getBalance();
				Transactions transactions = new Transactions();
				transactions.setMobileNo(mobileNo);
				transactions.setTransactionDetails(details);

				trepo.save(transactions);
		
			return repo.save(customer1);
			}
			else
				throw new InsufficientBalanceException("Amount to be withdrawn is greater than the balance.");
			
		}
		else
			throw new InvalidInputException("No such mobile number exists.");
	}
	
	
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		
		customer1=new Customer() ;
		customer2=new Customer() ;
		
		customer1 = repo.findOne(sourceMobileNo);
		customer2 = repo.findOne(targetMobileNo);
		
		if(customer1 != null && customer2 != null) {
			updatedBalance1 = customer1.getWallet().getBalance();
			
			int comp = updatedBalance1.intValue()-amount.intValue();
	        
			if(comp>0) {
				
				updatedBalance1 = null;
				updatedBalance1 = customer1.getWallet().getBalance().subtract(amount);
				
				wallet = new Wallet(updatedBalance1);
		        customer1.setWallet(wallet);
				
		        repo.delete(sourceMobileNo);
				
		        
		        Date dateOfTransaction = new Date();
				String details = "Wallet with mobile number: "+customer1.getMobileNo()+" has Fund transfer of "+ amount+" to mobile number "+targetMobileNo+" on "+dateFormat.format(dateOfTransaction)+" with Updated balance: "+customer1.getWallet().getBalance();
				Transactions transactions = new Transactions();
				transactions.setMobileNo(sourceMobileNo);
				transactions.setTransactionDetails(details); 
				trepo.save(transactions);
				
				updatedBalance2 = null;
				updatedBalance2 = customer2.getWallet().getBalance().add(amount);
				
				wallet = new Wallet(updatedBalance2);
				customer2.setWallet(wallet);
				
				repo.delete(targetMobileNo);
				
				customer2 = repo.save(customer2);
				dateOfTransaction = new Date();
				details = "Wallet with mobile number: "+customer2.getMobileNo()+" has Fund transfer of "+ amount+" from mobile number "+sourceMobileNo+" on "+dateFormat.format(dateOfTransaction)+" with Updated balance: "+customer2.getWallet().getBalance();
				transactions = new Transactions();
				transactions.setMobileNo(targetMobileNo);
				transactions.setTransactionDetails(details);

				trepo.save(transactions);
				
				
			
			return repo.save(customer1);
			}
			else
				throw new InsufficientBalanceException("Amount to be withdrawn is greater than the balance.");
			
		}
		else
			throw new InvalidInputException("No such mobile number exists.");
		
	}

	
	@Override
	public List<String> showTransaction(String mobileNo) {
		List<Transactions> transactionsList = new ArrayList<>();
		transactionsList = trepo.findAll();
//		transactions.getTransactionsList().add(details);
		List<String> TransactionsList1 = new ArrayList<String>();
//		transactions = trepo.findAll();
		if(transactionsList!=null)
		{
			Iterator<Transactions> it = transactionsList.iterator();
			
			while(it.hasNext()) {
				if(it.next().getMobileNo()==mobileNo)
				TransactionsList1.add(it.next().getTransactionDetails());
			}
			return TransactionsList1;
		}
		else
		    throw new InvalidInputException("No such mobile number exists.");
	}
	
	
	@Override
	public boolean isValid(Customer customer) throws InvalidInputException, InsufficientBalanceException {
	
	if(customer.getName() == null || customer.getName() == "")
		throw new InvalidInputException("User Name cannot be null or empty.");
	
	if(customer.getMobileNo() == null || customer.getMobileNo() == "")
		throw new InvalidInputException("User Mobile Number cannot be null or empty.");
	
	BigDecimal value = BigDecimal.ZERO;
	
	if(customer.getWallet().getBalance() == null ||customer.getWallet().getBalance().compareTo(value)==-1)
		throw new InvalidInputException("Wallet Balance cannot be Null.");
	
	if(!(customer.getName().matches("^([A-Z]{1}\\w+)$")))
	{
		throw new InvalidInputException("Invalid Name");
	}
	if(!(customer.getMobileNo().length()==10))
		throw new InvalidInputException("Mobile Number is not 10 digit.");
	
	if(!(customer.getMobileNo().matches("^[7-9]{1}[0-9]{9}$")))
		throw new InvalidInputException("Invalid Number");

	
		return true;
		
	}
	

}
