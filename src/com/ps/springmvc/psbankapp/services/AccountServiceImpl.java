package com.ps.springmvc.psbankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.springmvc.psbankapp.dao.AccountDAO;
import com.ps.springmvc.psbankapp.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO acccountDAO;
	
	@Override
	@Transactional
	public void saveAccount(Account account) {
		acccountDAO.saveAccount(account);
	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return acccountDAO.getAccounts();
	}

	@Override
	@Transactional
	public Account getAccount(Integer accountNo) {
		return acccountDAO.getAccount(accountNo);
	}

	@Override
	@Transactional
	public boolean deleteAccount(Integer accountNo) {
		return	acccountDAO.deleteAccount(accountNo);
	}

}
