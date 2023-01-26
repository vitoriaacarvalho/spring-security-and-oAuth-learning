package com.vitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.models.Flowers;
import com.vitoria.repositories.FlowersRepository;

@RestController
@RequestMapping("/flowers")
public class FlowersController {

	@Autowired
	private FlowersRepository repo;
	
	@GetMapping("/hello")
	public ResponseEntity<List<Flowers>> findAll(){
		List<Flowers> allFlowers=repo.findAll();
		return ResponseEntity.ok().body(allFlowers);
	}
	@PostMapping("/insert")
	public ResponseEntity<Flowers> insert(@RequestBody Flowers flower){
		Flowers entity=flower;
		repo.save(entity);
		return ResponseEntity.ok().body(entity);
	}
	
	
	
	
	
	
	
	
	
	
}
