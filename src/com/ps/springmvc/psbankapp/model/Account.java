package com.ps.springmvc.psbankapp.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ps.springmvc.psbankapp.validations.PSCode;

public class Account {
	
	@NotNull(message="Account# can't be blank.")
	private Integer accountNo;
	
	@NotNull(message="Account Holder's Name can't be blank.")
	@Size(min=2,max=50,message="Invalid Length for Account holder Name.")
	@Pattern(regexp="[A-Za-z(\\s)]+",message="Invalid Account Holder name.")
	private String accountHolderName;
	
	@NotNull/*(message="Account balance can't be blank.")*/
	@Min(value=5000,message="Minimum balance should not be less than 5000.")
	private Integer balance;
	
	@NotNull/*(message="Account type can't be blank.")*/
	private String accountType;
	
	@NotNull(message="Date Of Birth can't be blank.")
	@DateTimeFormat(pattern="mm/dd/yyyy")
	@Past(message="Account cannot be created for person not born.")
	private Date dateOfBirth;
	
	@NotNull(message="Security Code can't be blank.")
	@PSCode(value="PSUSA",message="Security code should start with PSUSA.")
	private String securityCode;
	
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

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
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
