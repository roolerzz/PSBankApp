package com.ps.springmvc.psbankapp.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Account {
	
	@NotNull(message="Account# can't be blank.")
	private Integer accountNo;
	
	@NotNull(message="Account Holder's Name can't be blank.")
	private String accountHolderName;
	
	@NotNull(message="Account balance can't be blank.")
	private Integer balance;
	
	@NotNull(message="Account type can't be blank.")
	private String accountType;
	
	@NotNull(message="Date Of Birth can't be blank.")
	@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date dateOfBirth;
	
	@NotNull(message="Security Code can't be blank.")
	private String psCode;
	
	public Account() {
		accountHolderName="";
		balance = 0;
		accountNo=0;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	public Account(Integer accNo, String holderName, Integer balance) {
		this.accountHolderName=holderName;
		this.accountNo=accNo;
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
