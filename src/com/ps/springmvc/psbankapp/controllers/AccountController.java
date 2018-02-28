package com.ps.springmvc.psbankapp.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.springmvc.psbankapp.model.Account;

@Controller
public class AccountController {

	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account",new Account());
		return "newAccount";
	}
	
	@RequestMapping("/showAccount")
	public String showAccount(Model model, Account account) {
		model.addAttribute("account",account);
		return "showAccount";
	}
	@RequestMapping(value="/saveAccount",method=RequestMethod.POST)
	public String saveAccount(@Valid  @ModelAttribute("account") Account account, BindingResult result) {
		/*String accNo = request.getParameter("accountNo");
		String accHolderName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");*/
		/*model.addAttribute("accountNo",accNo);
		model.addAttribute("accountHolderName",accHolderName);
		model.addAttribute("balance",balance);*/
		/*Account acc = new Account();
		acc.setAccountHolderName(customerName);
		acc.setAccountNo(Integer.parseInt(accNo));
		acc.setBalance(Integer.parseInt(balance));*/
		/*model.addAttribute("account", account);
		return "showAccount";*/
		
		if(result.hasErrors())
			return "newAccount";
		else 
			return "showAccount";
	}
}
