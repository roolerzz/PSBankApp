package com.ps.springmvc.psbankapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account",new Account());
		return "account-form";
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
			return "account-form";
		else 
			accountService.saveAccount(account);
			return "redirect:/list";
			//return "showAccount";
	}
	
	@GetMapping(value="/list")
	public String listAccounts(Model model) {
		List<Account> accounts = accountService.getAccounts();
		model.addAttribute("accounts",accounts);
		return "listAccounts";
	}
	
	@GetMapping(value="/edit")
	public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
		Account account = accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account",account);
		return "account-form";
	}
	
	@GetMapping(value="/delete")
	public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
		boolean deleted = accountService.deleteAccount(new Integer(accountNo));
		return "redirect:/list";
	}
	
}
