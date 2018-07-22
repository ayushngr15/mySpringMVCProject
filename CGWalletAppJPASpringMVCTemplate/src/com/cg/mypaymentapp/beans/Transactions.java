package com.cg.mypaymentapp.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Transactions implements Serializable 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trans_Id")
	private int trans_id;

	
	private String mobileNo;
	
	@Column(name="Transaction_Details")
    private String transactionDetails;


	public Transactions() {
		
	}


	
	public Transactions(String mobileNo, String transactionDetails) {
		super();
		this.mobileNo = mobileNo;
		this.transactionDetails = transactionDetails;
	}




	public Transactions(String mobileNo) {
		super();
		this.mobileNo = mobileNo;
	}


	


	public String getTransactionDetails() {
		return transactionDetails;
	}



	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}



	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	
   
	
     
     
     
}
