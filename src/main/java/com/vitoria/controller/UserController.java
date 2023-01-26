package com.vitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.models.Users;
import com.vitoria.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository repo;
	
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> users=repo.findAll();
		return ResponseEntity.ok().body(users);
	}
	/*
	@GetMapping()
	public ResponseEntity<Users> findByUsername(@RequestParam("username" String username)){
		List<Users> users=repo.findAll();
	}
	*/
	
	@PostMapping("/save")
	public ResponseEntity<Users> insert(@RequestBody Users user){
		Users entity=user;
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		repo.save(entity);
		return ResponseEntity.ok().body(entity);
	}
	
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
