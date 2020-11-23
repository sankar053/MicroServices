package com.iii.linkedin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LinkedIn")
public class LinkedInController {
	
	@GetMapping("/hellow/{name}")
	public String hellowWorld(@PathVariable String name) {
		return ("Hellow "+name);
	}

	
}
