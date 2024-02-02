package com.example.springdemoexamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping
	public String name() {
		
		return "KARTHIK";
	}
}
