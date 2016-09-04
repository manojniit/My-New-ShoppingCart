package com.niit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/")
	public String admin()
	{
		System.out.println("i'm in home");
	return "home";
	}
	@RequestMapping("/log")
	public String log()
	{
		System.out.println("i'm in log");
		return"log";
	}
}
