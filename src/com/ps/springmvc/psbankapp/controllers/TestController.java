package com.ps.springmvc.psbankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value= {"","/index","index*","view/*"})
	public String index() {
		return "testRequestMapping";
	}
	
}
