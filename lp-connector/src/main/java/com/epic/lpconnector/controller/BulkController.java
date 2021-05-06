package com.epic.lpconnector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epic.ceft.bean.CeftRequest;  

@RestController
public class BulkController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BulkController.class);
 
	@PostMapping("/ceft/credit")
    public CeftRequest ceft_credit( @RequestBody CeftRequest ceftRequest) {
		
		
		return ceftRequest; 
	}
	
	@GetMapping("/connect") 
	public String getMessage() {
		System.out.println("Greetings...! Use this to send SMS Bulks");
		return "1"; 
	}
}
