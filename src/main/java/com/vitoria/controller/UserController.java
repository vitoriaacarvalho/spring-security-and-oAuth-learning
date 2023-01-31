package com.vitoria.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.models.UserModel;
import com.vitoria.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> findAll(){
		List<UserModel> users=repo.findAll();
		return ResponseEntity.ok().body(users);
	}
	@GetMapping("/{username}")
	public ResponseEntity<Optional<UserModel>> findByUsername(@RequestParam("username")String username){
		Optional<UserModel> user=repo.findByUsername(username);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserModel> insert(@RequestBody UserModel user){
		UserModel entity=user;
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		repo.save(entity);
		return ResponseEntity.ok().body(entity);
	}
	
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
