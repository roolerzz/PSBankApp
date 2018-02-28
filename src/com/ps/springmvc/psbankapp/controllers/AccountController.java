package com.ps.springmvc.psbankapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showAccount(Model model, @ModelAttribute("account") Account acc) {
		model.addAttribute("account",acc);
		return "showAccount";
	}
	@RequestMapping(value="/saveAccount",method=RequestMethod.POST)
	public String saveAccount(Model model, HttpServletRequest request) {
		String accNo = request.getParameter("accountNo");
		String accHolderName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");
		/*model.addAttribute("accountNo",accNo);
		model.addAttribute("accountHolderName",accHolderName);
		model.addAttribute("balance",balance);*/
		Account acc = new Account();
		acc.setAccountHolderName(accHolderName);
		acc.setAccountNo(Integer.parseInt(accNo));
		acc.setBalance(Integer.parseInt(balance));
		model.addAttribute("account", acc);
		return "showAccount";
	}
}
