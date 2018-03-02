package com.ps.springmvc.psbankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountRestController {

	@Autowired
	AccountService accountService;

	/*@ResponseBody*/
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public Account getAccount(@PathVariable("id") Integer accountNo) {
		System.out.println("Requested account No : " + accountNo);
		Account account = accountService.getAccount(accountNo);
		return account;
	}
}
