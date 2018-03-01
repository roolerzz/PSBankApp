package com.ps.springmvc.psbankapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankapp.entity.AccountEntity;
import com.ps.springmvc.psbankapp.model.Account;


@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccount(Account account) {
		boolean saveFlag = true;
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccountNo(account.getAccountNo());
		accountEntity.setAccountHolderName(account.getAccountHolderName());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setSecurityCode(account.getSecurityCode());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(accountEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	
}
