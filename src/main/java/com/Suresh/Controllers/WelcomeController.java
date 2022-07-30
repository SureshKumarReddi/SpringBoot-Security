package com.Suresh.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String getMessage() {
		return "This is home page ";
	}
	
	@GetMapping("/statement")
	public String getstatement() {
		return "Statement page is returned ";
	}
	
	@GetMapping("/loan")
	public String getLaon() {
		return "loan amount needs to pay as 10000k ";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "contact page is thanks for contacting ";
	}
}
