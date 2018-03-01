package com.ps.springmvc.psbankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
			currentSession.saveOrUpdate(accountEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<AccountEntity> query = session.createQuery("From AccountEntity",AccountEntity.class);
			List<AccountEntity> accounts = query.getResultList();
			for(AccountEntity entity: accounts) {
				Account account = new Account();
				account.setAccountHolderName(entity.getAccountHolderName());
				account.setDateOfBirth(entity.getDateOfBirth());
				account.setBalance(entity.getBalance());
				account.setAccountNo(entity.getAccountNo());
				account.setSecurityCode(entity.getSecurityCode());
				account.setAccountType(entity.getAccountType());
				list.add(account);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {
		Account account = new Account();
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class,accountNo);
			account.setAccountHolderName(accountEntity.getAccountHolderName());
			account.setDateOfBirth(accountEntity.getDateOfBirth());
			account.setBalance(accountEntity.getBalance());
			account.setAccountNo(accountEntity.getAccountNo());
			account.setSecurityCode(accountEntity.getSecurityCode());
			account.setAccountType(accountEntity.getAccountType());
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return account;
	}

	@Override
	public boolean deleteAccount(Integer accountNo) {
		boolean deleteFlag=true;
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class,accountNo);
			session.delete(accountEntity);
		}
		catch(Exception e) {	
			e.printStackTrace();	
			deleteFlag=false;
		}
		return deleteFlag;
	}

	
}
