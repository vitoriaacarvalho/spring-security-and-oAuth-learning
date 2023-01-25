package com.vitoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.repositories.FlowersRepository;

@RestController
@RequestMapping("/flowers")
public class FlowersController {

	@Autowired
	private FlowersRepository repo;
	
	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld(){
		return ResponseEntity.ok().body("hello world");
	}
	
	
	
	
	
	
	
	
	
	
}
